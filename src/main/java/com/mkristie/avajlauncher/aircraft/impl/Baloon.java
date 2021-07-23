package com.mkristie.avajlauncher.aircraft.impl;

import com.mkristie.avajlauncher.aircraft.Aircraft;
import com.mkristie.avajlauncher.aircraft.Coordinates;
import com.mkristie.avajlauncher.aircraft.Flyable;
import com.mkristie.avajlauncher.exception.NoSuchWeatherException;
import com.mkristie.avajlauncher.tower.impl.WeatherTower;

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
    if (weatherTower != null) {
      int longitude = coordinates.getLongitude();
      int latitude = coordinates.getLatitude();
      int height = coordinates.getHeight();

      String weather = weatherTower.getWeather(coordinates);
      switch (weather) {
        case "SUN": {
          longitude += 2;
          height = Math.min(height + 4, 100);
          break;
        }
        case "RAIN": {
          height = Math.max(height - 5, 0);
          break;
        }
        case "FOG": {
          height = Math.max(height - 3, 0);
          break;
        }
        case "SNOW": {
          height = Math.max(height - 15, 0);
          break;
        }
        default: {
          throw new NoSuchWeatherException("There is no such weather: " + weather);
        }
      }
      coordinates = new Coordinates(longitude, latitude, height);
      writeWeatherMessage(weather);

      if (height == 0) {
        aircraftWriter.write(this + " landing.");
        weatherTower.unregister(this);
      }
    }
  }

  @Override
  public void registerTower(WeatherTower weatherTower) {
    this.weatherTower = weatherTower;
    this.weatherTower.register(this);
  }
}
