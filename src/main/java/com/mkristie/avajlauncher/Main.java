package com.mkristie.avajlauncher;

import com.mkristie.avajlauncher.parser.AircraftFileParser;
import java.io.FileNotFoundException;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    if (args.length != 1 || !args[0].endsWith(".txt")) {
      System.err.println("Please provide one and only one argument. In *.txt format");
    }

    try {
      new AircraftFileParser().parse(args[0]).runSimulation();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
