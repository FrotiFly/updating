config() -> {
    'scope' -> 'global'
 };


global_reach = 2.5;
global_player_count = 0;
global_bot_count = 0;

combo = false;
inCombo = false;
wtapping = false;

attackcooldown = 8;
stap = true;

global_botname = 'momhelpme';

global_fake = player('Bot');
global_player = player();


print('Booting Main System to '+ Bot);

sqr(x) -> x*x;
distance(pos1, pos2) -> sqrt(sqr(pos1:0-pos2:0)+sqr(pos1:1-pos2:1)+sqr(pos1:2-pos2:2));


fakeswing() -> (
  modify(player('Bot'),'swing');
  schedule(12,'fakeswing');
);
fakeswing();

Attack() -> (
  if (distance(global_player~'pos', global_fake~'pos') < global_reach,
     run('execute at Bot if entity @p[name=!'+ global_botname + '] run player Bot attack once');
  );
  schedule(12, 'Attack');
);
Attack();


Aim() -> (
	run('/execute at @p[name=!Bot] run player Bot look at ~ ~1.5 ~');
	run('/gamemode adventure @p[name=!FrostifyZX]');
    schedule(1, 'Aim');
);
Aim();


// strafe
 
strafedirection = 'right';
strafe = true;


movement() -> (
 run('/player Bot sprint');
 run('/player Bot move forward');
 if (strafe == true,
     if (strafedirection == 'right',
       run('/player move right');
	   );
	  );
	  
	if (strafe == true,
     if (strafedirection == 'left',
       run('/player move left');
	   );
	  );
 
 
 if (strafe == 'false',
     run('/player Bot stop');
	);
 schedule(1 ,'movement');
); 
movement();


__on_statistic(player, category, event, value) -> (
    entity = 'Bot';
   if (strafedirection == 'right',
       strafedirection = 'left';
	   );
	if (strafedirection == 'left',
       strafedirection = 'right';
	   );
	if (query(player('Bot'), 'on_ground') == false,
      strafe = false;
    ); 
	if (query(player('Bot'), 'on_ground') == true,
      strafe = true;
	  );
);

// sprint hits

__on_player_deals_damage(player, amount, entity) -> (
  if (player ~ 'player_type' == 'fake',
        run('/player Bot stop');
		stap = true;
		run('/player Bot move backward');
        run('/player Bot unsprint');
		run('/player Bot sprint');
		stap = false;
  ); 
 
);






