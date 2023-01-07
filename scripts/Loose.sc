__config() -> {
  'stay_loaded'->false
};



run('/title @p[name=!Bot] title {"text":"You Lost","color":"red"}');
run('/title @p[name=!Bot] subtitle {"text":"Oof you lost","color":"red"}');
run('/kill Bot');
run('/tp @p[name=!Bot] 8895 203 -3996');
run('/effect give @a minecraft:regeneration 1 255 true');
run('/script unload boxing');
run('/script unload sumo');
run('/script unload tank');
