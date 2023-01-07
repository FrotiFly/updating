global_counter = 3;

run('/tp @p[name=Bot] 8598 117.5 8400');
run('/tp @p[name=!Bot] 8598 117.5 8407');

countdown() -> (
  display_title('FrostifyZX', 'title', global_counter, 5, 7, 5);
  global_counter += -1;	
	if (global_counter >= 0,
	    run('/playsound minecraft:entity.arrow.hit_player player @p[name=!Bot]');
        schedule(20, 'countdown');
    );
	
	if (global_counter < 0,
	    display_title(player('all');, 'title', 'GO', 5, 7, 5);
		run('/playsound minecraft:block.amethyst_block.hit player @p[name=!Bot]');
    );
  
);
countdown();

stayinplace() -> (
    if (global_counter > 0,
	    run('/tp @p[name=Bot] 8598 117.5 8400');
			  
	   run('/tp @p[name=!Bot] 8598 117.5 8407');
	    
    );
	schedule(1, 'stayinplace');
);
stayinplace();

__on_statistic(player, category, event, value) -> (
   if (block(pos_offset(player('Bot')~'pos', 'down', 1)) == 'glass',
       run('/script load win');
	   run('/script unload sumo');
	   
	   );
for(player('all'),
    if(_~'player_type' != 'fake' && block(pos_offset(_~'pos', 'down', 1)) == 'glass',
         run('/script load loose');
	     run('/script unload sumo');
    );
);
	   
);