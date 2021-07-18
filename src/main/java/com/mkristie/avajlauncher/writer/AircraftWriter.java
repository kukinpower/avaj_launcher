package com.mkristie.avajlauncher.writer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AircraftWriter {

  private static final String DEFAULT_FILENAME = "simulation.txt";
  private final String filename;

  public AircraftWriter() {
    filename = DEFAULT_FILENAME;
  }

  public AircraftWriter(String filename) {
    this.filename = filename;
  }

  public void write(String message) {
    try {
      Files.write(Paths.get(filename), message.getBytes(StandardCharsets.UTF_8));
    } catch (IOException e) {
      System.err.println("couldn't write to file" + filename);
    }
  }
}
