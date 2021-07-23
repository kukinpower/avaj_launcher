package com.mkristie.avajlauncher.aircraft;

import com.mkristie.avajlauncher.aircraft.impl.Baloon;
import com.mkristie.avajlauncher.aircraft.impl.Helicopter;
import com.mkristie.avajlauncher.aircraft.impl.JetPlane;
import com.mkristie.avajlauncher.exception.IllegalAircraftTypeException;
import java.util.HashMap;
import java.util.Map;

public abstract class AircraftFactory {

  private static final String BALOON = "Baloon";
  private static final String JETPLANE = "JetPlane";
  private static final String HELICOPTER = "Helicopter";

  public final static Map<String, String> TYPE_HASH = new HashMap<>();

  static {
    TYPE_HASH.put(BALOON, "994736B4F0AEC72F6E5AE580051D012F");
    TYPE_HASH.put(JETPLANE, "554CD647D6B135F7E36AB1214C5E816A");
    TYPE_HASH.put(HELICOPTER, "2AB8B43468E8B92B0FC5C81E70E35A2D");
  }

  public static Flyable newAircraft(String type, String name,
      int longitude, int latitude, int height) {

    Coordinates coordinates = new Coordinates(longitude, latitude, height);

    if (BALOON.equals(type) || TYPE_HASH.get(BALOON).equals(type)) {
      return new Baloon(name, coordinates);
    }
    if (JETPLANE.equals(type) || TYPE_HASH.get(JETPLANE).equals(type)) {
      return new JetPlane(name, coordinates);
    }
    if (HELICOPTER.equals(type) || TYPE_HASH.get(HELICOPTER).equals(type)) {
      return new Helicopter(name, coordinates);
    }

    throw new IllegalAircraftTypeException(type);
  }
}
