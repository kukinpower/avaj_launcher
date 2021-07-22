package com.mkristie.avajlauncher.aircraft.impl;

import com.mkristie.avajlauncher.aircraft.Aircraft;
import com.mkristie.avajlauncher.aircraft.Coordinates;
import com.mkristie.avajlauncher.aircraft.Flyable;
import com.mkristie.avajlauncher.exception.NoSuchWeatherException;
import com.mkristie.avajlauncher.tower.impl.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

  private WeatherTower weatherTower;

  public JetPlane(String name, Coordinates coordinates) {
    super(name, coordinates);
  }

  @Override
  public void updateConditions() {
    if (weatherTower != null) {
      int longitude = coordinates.getLongitude();
      int latitude = coordinates.getLatitude();
      int height = coordinates.getHeight();

      String weather = weatherTower.getWeather(coordinates);
      switch (weather) {
        case "SUN": {
          latitude += 10;
          height = Math.min(height + 2, 100);
          break;
        }
        case "RAIN": {
          latitude += 5;
          break;
        }
        case "FOG": {
          latitude += 1;
          break;
        }
        case "SNOW": {
          height = Math.max(height - 7, 0);
          break;
        }
        default: {
          throw new NoSuchWeatherException("There is no such weather: " + weather);
        }
      }
      coordinates = new Coordinates(longitude, latitude, height);
      writeWeatherMessage(weather);

      if (height == 0) {
        aircraftWriter.write(this + " landed");
        weatherTower.unregister(this);
      }
    }
  }

  @Override
  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    this.weatherTower.register(this);
  }

  @Override
  public String toString() {
    return "JetPlane#" + name + "(" + id + ")";
  }
}
