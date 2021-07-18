package com.mkristie.avajlauncher.aircraft.impl;

import com.mkristie.avajlauncher.Coordinates;
import com.mkristie.avajlauncher.aircraft.Aircraft;
import com.mkristie.avajlauncher.aircraft.Flyable;
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
//    SUN- Longitude increases with 2, Height increases with 4◦RAIN- Height decreases with 5◦FOG- Height decreases with 3◦SNOW- Height decreases with 15
    if (weatherTower != null) {

    }
  }

  @Override
  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    weatherTower.register(this);
  }
}
