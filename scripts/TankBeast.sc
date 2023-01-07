__config() -> {
  'stay_loaded'->false
};


global_counter = 3;
run('/player Bot spawn at 8536.349 65 8485.231');

run('/script load main');

run('/item replace entity @a armor.head with minecraft:diamond_helmet');
run('/item replace entity @a armor.chest with minecraft:diamond_chestplate');
run('/item replace entity @a armor.legs with minecraft:diamond_leggings');
run('/item replace entity @a armor.feet with minecraft:diamond_boots');
run('/item replace entity @a weapon.mainhand with minecraft:diamond_sword');
run('/scoreboard players set @a resistance 0');

run('/effect give @a minecraft:regeneration 1 255 true');

countdown() -> (
  display_title(player('all'), 'title', global_counter, 5, 7, 5);
  global_counter += -1;	
	if (global_counter >= 0,
	    run('/playsound minecraft:entity.arrow.hit_player player @a');
		run('/effect give @a minecraft:regeneration 1 255 true');
        schedule(20, 'countdown');
    );
	
	if (global_counter < 0,
	    display_title(player('all');, 'title', 'GO', 5, 7, 5);
		run('/playsound minecraft:block.amethyst_block.hit player @a');
		run('/effect clear @a');
    );
  
);
countdown();

stayinplace() -> (
    if (global_counter > 0,
	    run('/tp Bot 8536.349 66.5 8485.231');
        run('/tp @p[name=!Bot] 8536.307 66.5 8406.640'); 
	    
    );
	schedule(1, 'stayinplace');
);
stayinplace();

__on_player_dies(player) -> (
   if (player ~ 'player_type' == 'fake',
      run('script load win');
	  run('/effect give @a minecraft:instant_health 1 255 true');
	  run('/scoreboard players set @a resistance 1');
	);
   if (entity ~ 'player_type' == 'fake',
       run('script load loose');
	   run('/effect give @a minecraft:instant_health 1 255 true');
	   run('/scoreboard players set @a resistance 1');
   );
);