package com.mkristie.avajlauncher;

import com.mkristie.avajlauncher.parser.AircraftFileParser;
import com.mkristie.avajlauncher.writer.AircraftWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  public static void main(String[] args) {
    if (args.length != 1 || !args[0].endsWith(".txt")) {
      System.err.println("Please provide one and only one argument. In *.txt format");
      return;
    }

    try {
      Files.deleteIfExists(Paths.get(AircraftWriter.getWriterFilename()));
      new AircraftFileParser().parse(args[0]).runSimulation();
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
