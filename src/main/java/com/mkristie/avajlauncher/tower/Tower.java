package com.mkristie.avajlauncher.tower;

import com.mkristie.avajlauncher.aircraft.Flyable;
import com.mkristie.avajlauncher.writer.AircraftWriter;
import java.util.ArrayList;
import java.util.List;

public abstract class Tower {

  private final List<Flyable> registeredSubscribers = new ArrayList<>();
  private final List<Flyable> unregisteredSubscribers = new ArrayList<>();
  private final static AircraftWriter aircraftWriter = AircraftWriter.getWriter();

  public void register(Flyable flyable) {
    registeredSubscribers.add(flyable);
    aircraftWriter.write("Tower says: " + flyable + " registered to weather tower.");
  }

  public void unregister(Flyable flyable) {
    unregisteredSubscribers.add(flyable);
    aircraftWriter.write("Tower says: " + flyable + " unregistered from weather tower.");
  }

  protected void conditionsChanged() {
    for (Flyable observer : registeredSubscribers) {
      observer.updateConditions();
    }
    registeredSubscribers.removeAll(unregisteredSubscribers);
    unregisteredSubscribers.clear();
  }
}
