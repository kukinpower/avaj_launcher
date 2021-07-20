package com.mkristie.avajlauncher.tower.impl;

import com.mkristie.avajlauncher.aircraft.Coordinates;
import com.mkristie.avajlauncher.tower.Tower;
import com.mkristie.avajlauncher.weather.WeatherProvider;

public final class WeatherTower extends Tower {

  String getWeather(Coordinates coordinates) {
    return WeatherProvider.getProvider().getCurrentWeather(coordinates);
  }

  void changeWeather() {
    conditionsChanged();
  }
}
