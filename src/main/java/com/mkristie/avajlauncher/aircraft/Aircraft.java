package com.mkristie.avajlauncher.aircraft;

import com.mkristie.avajlauncher.writer.AircraftWriter;

public abstract class Aircraft {

  protected final AircraftWriter aircraftWriter = AircraftWriter.getWriter();

  private static long idCounter = 0;

  protected final long id;
  protected final String name;
  protected Coordinates coordinates;

  public Aircraft(String name, Coordinates coordinates) {
    id = nextId();
    this.name = name;
    this.coordinates = coordinates;
  }

  private static long nextId() {
    return ++idCounter;
  }

  protected void writeWeatherMessage(String weather) {
    aircraftWriter.write(this + ": " + weather + " " + coordinates);
  }
}
