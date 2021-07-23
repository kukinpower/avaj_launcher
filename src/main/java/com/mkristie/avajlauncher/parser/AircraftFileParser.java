package com.mkristie.avajlauncher.parser;

import com.mkristie.avajlauncher.aircraft.AircraftFactory;
import com.mkristie.avajlauncher.aircraft.Flyable;
import com.mkristie.avajlauncher.exception.AircraftFileParserException;
import com.mkristie.avajlauncher.exception.BadFileFormatException;
import com.mkristie.avajlauncher.simulation.AircraftSimulation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AircraftFileParser {

  private static final List<String> TYPES = Arrays.asList("baloon", "jetplane", "helicopter");

  private int extractEpochsCount(Scanner scanner) {
    try {
      int epochs = Integer.parseInt(scanner.nextLine());
      if (epochs <= 0) {
        throw new BadFileFormatException("Epochs count must be greater than 0");
      }
      return epochs;
    } catch (NumberFormatException e) {
      throw new BadFileFormatException(
          "First line of a file must be a count of epochs. Decimal number");
    } catch (NoSuchElementException e) {
      throw new BadFileFormatException("You passed an empty file");
    } catch (Exception e) {
      throw new BadFileFormatException("You passed a bad file");
    }
  }

  private List<Flyable> extractAircrafts(Scanner scanner) {
    List<Flyable> aircrafts = new ArrayList<>();

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      String[] aircraft = line.split(" ");
      if (aircraft.length != 5) {
        throw new BadFileFormatException(
            "Bad aircraft line format. Should be: type name longitude latitude height");
      }
      try {
        String type = aircraft[0];
        if (!TYPES.contains(type.toLowerCase(Locale.ROOT))) {
          throw new IllegalArgumentException("There's no such type: " + type
              + ". Expected types: baloon, helicopter, jetplain");
        }
        String name = aircraft[1];
        int longitude = Integer.parseInt(aircraft[2]);
        int latitude = Integer.parseInt(aircraft[3]);
        int height = Integer.parseInt(aircraft[4]);
        if (longitude <= 0 || latitude <= 0 || height <= 0) {
          throw new IllegalArgumentException("Coordinates must be positive");
        }

        aircrafts.add(AircraftFactory.newAircraft(type, name, longitude, latitude, height));
      } catch (NumberFormatException e) {
        throw new BadFileFormatException(
            "longitude latitude and height must be not negative numbers");
      }
    }
    return aircrafts;
  }

  public AircraftSimulation parse(String filename) throws FileNotFoundException {
    try (Scanner scanner = new Scanner(new File(filename))) {
      return new AircraftSimulation(extractEpochsCount(scanner), extractAircrafts(scanner));
    } catch (Exception e) {
      throw new AircraftFileParserException(e);
    }
  }
}
