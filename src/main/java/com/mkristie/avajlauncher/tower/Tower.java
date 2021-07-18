package com.mkristie.avajlauncher.tower;

import com.mkristie.avajlauncher.flyable.Flyable;
import java.util.ArrayList;
import java.util.List;

public abstract class Tower {

  private final List<Flyable> registeredSubscribers = new ArrayList<>();
  private final List<Flyable> unregisteredSubscribers = new ArrayList<>();

  public void register(Flyable flyable) {
    registeredSubscribers.add(flyable);
  }

  public void unregister(Flyable flyable) {
    unregisteredSubscribers.add(flyable);
  }

  protected void conditionsChanged() {
    for (Flyable observer : registeredSubscribers) {
      observer.updateConditions();
    }
    registeredSubscribers.removeAll(unregisteredSubscribers);
    unregisteredSubscribers.clear();
  }
}
