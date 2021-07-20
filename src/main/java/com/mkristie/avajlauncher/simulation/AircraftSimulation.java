package com.mkristie.avajlauncher.simulation;

import com.mkristie.avajlauncher.aircraft.Flyable;
import java.util.List;

public class AircraftSimulation {

  private final int epochsCount;
  private final List<Flyable> aircrafts;

  public AircraftSimulation(int epochsCount,
      List<Flyable> aircrafts) {
    this.epochsCount = epochsCount;
    this.aircrafts = aircrafts;
  }

  public void runSimulation() {
    for (int i = 0; i < epochsCount; i++) {

    }
  }
}
