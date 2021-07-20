package com.mkristie.avajlauncher.aircraft;

public abstract class Aircraft {

  protected final long id;
  protected final String name;
  protected final Coordinates coordinates;
  private static long idCounter = 0;

  public Aircraft(String name, Coordinates coordinates) {
    id = nextId();
    this.name = name;
    this.coordinates = coordinates;
  }

  private static long nextId() {
    return ++idCounter;
  }
}
