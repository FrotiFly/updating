config() -> {
    'scope' -> 'global',
	'stay_loaded'->false
};
 


tankkits = create_screen(player(),'generic_9x1',format('t Tank Kits'),_(screen, player, action, data) -> (
 if (action == 'pickup' && data:'slot' == 0,  
	  run('/script load tankbeast');
	  close_screen(screen);
  );
			 
 if (action == 'pickup' && data:'slot' == 1,
  run('/script load tankspeed');  
  close_screen(screen);
 );
			 
  if (action == 'pickup' && data:'slot' == 2,
    close_screen(screen);
    run('/script load tankcombo');	
  );
));
inventory_set(tankkits,0,1, 'diamond_sword','{display:{Name:\'{"text":"Beast Kit" ,"color":"blue"}\'}}');
inventory_set(tankkits,1,1, 'diamond_sword','{display:{Name:\'{"text":"Speed Kit" ,"color":"yellow"}\'}, Enchantments:[{id:"minecraft:Sharpness",lvl:2s}]}');
inventory_set(tankkits,2,1, 'wooden_sword','{display:{Name:\'{"text":"Combo Kit" ,"color":"green"}\'}}');
