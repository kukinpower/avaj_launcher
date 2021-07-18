package com.mkristie.avajlauncher.flyable;

import com.mkristie.avajlauncher.tower.WeatherTower;

public interface Flyable {

  void updateConditions();

  void registerTower(WeatherTower weatherTower);
}
