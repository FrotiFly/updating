__config() -> {
  'stay_loaded'->false
};


run('/playsound minecraft:entity.arrow.hit_player player @a');
run('/title @p[name=!Bot] title {"text":"Victory","color":"green"}');
run('/title @p[name=!Bot] subtitle {"text":"You won against the bot","color":"green"}');
run('/clear @a');
run('/effect give @a minecraft:regeneration 1 255 true');
global_counter = 1;
run('/script unload boxing');
run('/script unload sumo');
run('/script unload tank');

countdown() -> (
  global_counter += -1;	
	if (global_counter >= 0,
	run('/effect give @a minecraft:instant_health 1 255 true');
        schedule(20, 'countdown');
    );
	
	if (global_counter < 0,
        run('/kill Bot');
        run('/tp @p[name=!Bot] 8895 203 -3996');
    );
  
);
countdown();
