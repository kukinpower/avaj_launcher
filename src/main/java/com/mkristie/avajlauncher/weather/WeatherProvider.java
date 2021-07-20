package com.mkristie.avajlauncher.weather;

import com.mkristie.avajlauncher.aircraft.Coordinates;

public class WeatherProvider {

  private static volatile  WeatherProvider weatherProvider;
  private static String[] weather = new String[]{"SUN", "RAIN", "FOG", "SNOW"};

  private WeatherProvider() {
  }

  public static WeatherProvider getProvider() {
    WeatherProvider result = weatherProvider;
    if (result != null) {
      return result;
    }
    synchronized(WeatherProvider.class) {
      if (weatherProvider == null) {
        weatherProvider = new WeatherProvider();
      }
      return weatherProvider;
    }
  }

  public String getCurrentWeather(Coordinates coordinates) {
    return weather[0];//todo calc
  }
}
