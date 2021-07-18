package com.mkristie.avajlauncher.aircraft;

import com.mkristie.avajlauncher.tower.WeatherTower;

public interface Flyable {

  void updateConditions();

  void registerTower(WeatherTower weatherTower);
}
