loadbot() -> (
 run('/player Bot spawn at 8536.349 65 8485.231');
 run('/script load main');

);

print('update 1.1.2');

xd() -> (
  
  run('/gamemode adventure @p[name=!FrostifyZX]');
  
  schedule(1,'xd');
  
);
xd();


__on_player_uses_item(player, item_tuple, hand) -> (
	l(item, count, nbt) = item_tuple || l('None', 0, null);
    if (item ~ 'iron_sword',
        // If the compass is unnamed, do nothing.
        if (nbt == null || nbt:'display' == null, return()); 
        // Get the name from the compass and store it in "target".
        name = nbt:'display':'Name';
		
		if (name ~ 'Gamemodes',
	       screen = create_screen(player(),'generic_9x1',format('pb Bot Duels'),_(screen, player, action, data) ->  (
		   
		   if (action == 'pickup' && data:'slot' == 0,
		       startcounter = 3;
			   counter = true;
		       run('/player Bot spawn at 8536.349 65 8485.231');
			   run('/tp @p[name=!Bot] 8536.307 65 8406.640');
			  
			   close_screen(screen);
			   
			   
			   run('/clear @a');
			   loadbot();
			   
			   run('/give @a diamond_sword{Enchantments:[{id:"minecraft:sharpness",lvl:10s}]}');
			   run('/script load boxing');
			  
               
			 );
			 
			 if (action == 'pickup' && data:'slot' == 1,
		       run('/clear @a');
			   close_screen(screen);
			   loadbot();
			   run('script unload boxing');
			   run('script load sumo');
			   run('/clear @a');
			   loadbot();
			   
               
			 );
			 
			  if (action == 'pickup' && data:'slot' == 2,
		         // nothing
				 
				 close_screen(screen);
				 run('script load Tank');
			 );
			 
			 if (action == 'pickup' && data:'slot' == 3,
		         // nothing
				 
				 close_screen(screen);
				 run('script load shield');
			 );
			 
			 if (action == 'pickup',
			     run('/scoreboard objectives remove Lobby');
				 
                 //scoreboard removal
			 );
           
		   
		   
            );
		   );
		   
		   inventory_set(screen,data:'slot',1, 'diamond_sword','{display:{Name:\'{"text":"Boxing" ,"color":"blue"}\'}}');
	       inventory_set(screen,1,1, 'stick','{display:{Name:\'{"text":"Sumo" ,"color":"gold"}\'}}');
	       
		   inventory_set(screen,2,1, 'diamond_helmet','{display:{Name:\'{"text":"Tank" ,"color":"red"}\'}}');
		   inventory_set(screen,3,1, 'shield','{display:{Name:\'{"text":"Shield" ,"color":"yellow"}\'}}');
		);
		
		
	);
);
