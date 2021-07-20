package com.mkristie.avajlauncher;

import com.mkristie.avajlauncher.aircraft.impl.Baloon;
import com.mkristie.avajlauncher.aircraft.Flyable;
import com.mkristie.avajlauncher.aircraft.impl.JetPlain;
import com.mkristie.avajlauncher.parser.AircraftFileParser;
import java.io.FileNotFoundException;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    if (args.length != 1 || !args[0].endsWith(".txt")) {
      System.err.println("Please provide one and only one argument. In *.txt format");
    }

    new AircraftFileParser().parse(args[0]);

    //read the file with scanner
    //add custom exceptions
    //check coords
  }
}
