package com.mkristie.avajlauncher.aircraft;

import com.mkristie.avajlauncher.Coordinates;
import com.mkristie.avajlauncher.tower.WeatherTower;

public class JetPlain extends Aircraft implements Flyable {

  private WeatherTower weatherTower;

  public JetPlain(String name, Coordinates coordinates) {
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
    return "JetPlain#" + name + "(" + id + ")";
  }
}
