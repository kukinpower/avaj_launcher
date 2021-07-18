package com.mkristie.avajlauncher.aircraft;

import com.mkristie.avajlauncher.Coordinates;
import com.mkristie.avajlauncher.tower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {

  private WeatherTower weatherTower;

  public Helicopter(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  @Override
  public void updateConditions() {

  }

  @Override
  public void registerTower(WeatherTower weatherTower) {

  }

  @Override
  public String toString() {
    return "Helicopter#" + name + "(" + id + ")";
  }
}
