package com.mkristie.avajlauncher.writer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public final class AircraftWriter {

  private static final String DEFAULT_FILENAME = "simulation.txt";
  private final String filename;
  private static volatile AircraftWriter aircraftWriter;

  private AircraftWriter(String filename) {
    this.filename = filename;
    try {
      Files.createFile(Paths.get(filename));
    } catch (IOException e) {

    }
  }

  /**
   * It may seem that having the `result` variable here is completely
   * pointless. There is, however, a very important caveat when
   * implementing double-checked locking in Java, which is solved by
   * introducing this local variable.
   *
   * You can read more info DCL issues in Java here:
   * https://refactoring.guru/java-dcl-issue
   * @param filename name of the file
   * @return writer instance
   */
  public static AircraftWriter getWriter(String filename) {
    AircraftWriter result = aircraftWriter;
    if (result != null) {
      return result;
    }
    synchronized(AircraftWriter.class) {
      if (aircraftWriter == null) {
        aircraftWriter = new AircraftWriter(filename);
      }
      return aircraftWriter;
    }
  }

  public static AircraftWriter getWriter() {
    return getWriter(DEFAULT_FILENAME);
  }

  public static String getWriterFilename() {
    AircraftWriter result = aircraftWriter;
    if (result != null) {
      return result.filename;
    }
    return DEFAULT_FILENAME;
  }

  public void write(String message) {
    message += "\n";
    try {
      Files.write(Paths.get(filename), message.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    } catch (IOException e) {
      System.err.println("couldn't write to file " + filename);
    }
  }
}
