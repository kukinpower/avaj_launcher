package com.mkristie.avajlauncher.simulation;

import com.mkristie.avajlauncher.aircraft.Flyable;
import com.mkristie.avajlauncher.tower.impl.WeatherTower;
import java.util.List;

public class AircraftSimulation {

  private final int epochsCount;
  private final List<Flyable> aircrafts;
  private final WeatherTower weatherTower;

  public AircraftSimulation(int epochsCount, List<Flyable> aircrafts) {
    this.epochsCount = epochsCount;
    this.aircrafts = aircrafts;
    this.weatherTower = new WeatherTower();
    for (Flyable aircraft : this.aircrafts) {
      aircraft.registerTower(this.weatherTower);
    }
  }

  public void runSimulation() {
    for (int i = 0; i < epochsCount; i++) {
      weatherTower.changeWeather();
    }
  }
}
