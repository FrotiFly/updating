global_counter = 3;

countdown() -> (
  display_title('FrostifyZX', 'title', global_counter, 5, 7, 5);
  global_counter += -1;	
	if (global_counter >= 0,
	    run('/playsound minecraft:entity.arrow.hit_player player @a');
        schedule(20, 'countdown');
    );
	
	if (global_counter < 0,
	    display_title(player('all');, 'title', 'GO', 5, 7, 5);
		run('/playsound minecraft:block.amethyst_block.hit player @a');
    );
  
);
countdown();

stayinplace() -> (
    if (global_counter > 0,
	    run('/player Bot spawn at 8536.349 65 8485.231');
	    run('/tp @p[name=!Bot] 8536.307 65 8406.640');
	    run('/execute as @r run tp @s ~ ~1.5 ~');
    );
	schedule(1, 'stayinplace');
);
stayinplace();