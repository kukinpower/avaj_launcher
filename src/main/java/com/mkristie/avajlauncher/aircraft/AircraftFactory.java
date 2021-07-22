package com.mkristie.avajlauncher.aircraft;

import com.mkristie.avajlauncher.aircraft.impl.Baloon;
import com.mkristie.avajlauncher.aircraft.impl.Helicopter;
import com.mkristie.avajlauncher.aircraft.impl.JetPlane;
import com.mkristie.avajlauncher.exception.IllegalAircraftTypeException;
import java.util.Locale;

public abstract class AircraftFactory {

  public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {

    Coordinates coordinates = new Coordinates(longitude, latitude, height);

    switch (type.toLowerCase(Locale.ROOT)) {
      case "baloon": {
        return new Baloon(name, coordinates);
      }
      case "jetplane": {
        return new JetPlane(name, coordinates);
      }
      case "helicopter": {
        return new Helicopter(name, coordinates);
      }
      default: {
        throw new IllegalAircraftTypeException(type);
      }
    }
  }
}
