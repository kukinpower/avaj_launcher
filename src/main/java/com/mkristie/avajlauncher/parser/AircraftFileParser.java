package com.mkristie.avajlauncher.parser;

import com.mkristie.avajlauncher.aircraft.AircraftFactory;
import com.mkristie.avajlauncher.aircraft.Flyable;
import com.mkristie.avajlauncher.exception.BadFileFormatException;
import com.mkristie.avajlauncher.simulation.AircraftSimulation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AircraftFileParser {

  private int extractEpochsCount(Scanner scanner) {
    try {
      int epochs = Integer.parseInt(scanner.nextLine());
      if (epochs <= 0) {
        throw new BadFileFormatException("Epochs count must be greater than 0");
      }
      return epochs;
    } catch (NumberFormatException e) {
      throw new BadFileFormatException("First line of a file must be a count of epochs. Decimal number");
    }
  }

  private List<Flyable> extractAircrafts(Scanner scanner) {
    List<Flyable> aircrafts = new ArrayList<>();

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] aircraft = line.split(" ");
      if (aircraft.length != 5) {
        throw new BadFileFormatException("Bad aircraft line format. Should be: type name longitude latitude height");
      }
      try {
        aircrafts.add(AircraftFactory.newAircraft(
            aircraft[0],
            aircraft[1],
            Integer.parseInt(aircraft[2]),
            Integer.parseInt(aircraft[3]),
            Integer.parseInt(aircraft[4])));
      } catch (NumberFormatException e) {
        throw new BadFileFormatException("longitude latitude and height must be not negative numbers");
      }
    }
    return aircrafts;
  }

  public AircraftSimulation parse(String filename) throws FileNotFoundException {
    try (Scanner scanner = new Scanner(new File(filename))) {
      return new AircraftSimulation(extractEpochsCount(scanner), extractAircrafts(scanner));
    }
  }
}
