
 config() -> {
    'scope' -> 'global',
	'stay_loaded'->false
};

run('/tp Bot 8536.349 65 8485.231');
run('/tp @p[name=!Bot] 8536.307 65 8406.640');

global_player_count = 0;
global_bot_count = 0;
global_combo = 0;

global_counter = 3;

run('/scoreboard players set @a resistance 1');
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
	    run('/tp Bot 8536.349 66.5 8485.231');
        run('/tp @p[name=!Bot] 8536.307 66.5 8406.640'); 
	    
    );
	schedule(1, 'stayinplace');
);
stayinplace();


__on_player_deals_damage(player, amount, entity) -> (
     print(player('*'),player + ' hit ' + entity);
	 if (entity ~ 'player_type' == 'fake',
	  global_player_count = global_player_count + 1;
	  print('Player : bot,player' + global_bot_count + ',' + global_player_count);
	,
	  player ~ 'player_type' == 'fake',
	  global_bot_count = global_bot_count + 1;
	  print('Bot: bot,player' + global_bot_count + ',' + global_player_count);
	);
	 print('bot,player' + global_bot_count + ',' + global_player_count);
  
    if (global_bot_count == 100,
	   
        global_player_count = 0;
        global_bot_count = 0;
		run('/scoreboard objectives remove Boxing');
        run('script load loose');
		
    ,
	    
        global_player_count == 100,
		

        global_player_count = 0;
        global_bot_count = 0;
		run('/scoreboard objectives remove Boxing');
        run('script load win');
		
   
    );
	update_scoreboard();
 );
    
//scorboard

scoreboard_add('Boxing');
scoreboard_property('Boxing','display_name',format('c NA Practice Bots'));
scoreboard('Boxing','§8§l-------------------',8);
scoreboard('Boxing','Hits :',7);
scoreboard('Boxing',str('§b|    §aYou :', ),6);
scoreboard('Boxing',str('§b|    §cThem :', global_bot_count),5);
scoreboard('Boxing','§aNo Combo',4);
scoreboard('Boxing',' ',3);
scoreboard('Boxing','§bAzurite.club',2);
scoreboard('Boxing','§8§l -------------------',1);
scoreboard_display('sidebar','Boxing');

update_scoreboard()->(
  for(scoreboard('Boxing'),scoreboard_remove('Boxing',_));
scoreboard_property('Boxing','display_name',format('c NA Practice Bots'));
scoreboard('Boxing','§8§l-------------------',8);
scoreboard('Boxing','Hits :',7);
scoreboard('Boxing',str('§b|    §aYou : %d', global_player_count),6);
scoreboard('Boxing',str('§b|    §cThem : %d', global_bot_count),5);
scoreboard('Boxing','§aNo Combo',4);
scoreboard('Boxing',' ',3);
scoreboard('Boxing','§bAzurite.club',2);
scoreboard('Boxing','§8§l -------------------',1);
scoreboard_display('sidebar','Boxing');
);