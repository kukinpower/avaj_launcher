package com.mkristie.avajlauncher.aircraft;

import com.mkristie.avajlauncher.Coordinates;
import com.mkristie.avajlauncher.tower.WeatherTower;
import com.mkristie.avajlauncher.writer.AircraftWriter;

public class Baloon extends Aircraft implements Flyable {

  private WeatherTower weatherTower;

  public Baloon(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  @Override
  public String toString() {
    return "Baloon#" + name + "(" + id + ")";
  }

  @Override
  public void updateConditions() {

  }

  @Override
  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    weatherTower.register(this);
  }
}
