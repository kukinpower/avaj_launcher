package com.mkristie.avajlauncher.aircraft.impl;

import com.mkristie.avajlauncher.aircraft.Aircraft;
import com.mkristie.avajlauncher.aircraft.Coordinates;
import com.mkristie.avajlauncher.aircraft.Flyable;
import com.mkristie.avajlauncher.tower.impl.WeatherTower;

public class JetPlain extends Aircraft implements Flyable {

  private WeatherTower weatherTower;

  public JetPlain(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  @Override
  public void updateConditions() {
//SUN- Latitude increases with 10, Height increases with 2◦RAIN- Latitude increases with 5◦FOG- Latitude increases with 1◦SNOW- Height decreases with 7
  }

  @Override
  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    weatherTower.register(this);
  }

  @Override
  public String toString() {
    return "JetPlain#" + name + "(" + id + ")";
  }
}
