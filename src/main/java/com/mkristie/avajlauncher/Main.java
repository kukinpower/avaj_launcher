package com.mkristie.avajlauncher;

import com.mkristie.avajlauncher.aircraft.impl.Baloon;
import com.mkristie.avajlauncher.aircraft.Flyable;
import com.mkristie.avajlauncher.aircraft.impl.JetPlain;

public class Main {

  public static void main(String[] args) {
//    if (args.length != 1 || !args[0].endsWith(".txt")) {
//      System.err.println("Please provide one and only one argument. In *.txt format");
//    }

    Coordinates coordinates = new Coordinates(10, 10, 10);
    Flyable baloon = new Baloon("baloon", coordinates);
    Flyable jetPlain = new JetPlain("jetplain", coordinates);

    System.out.println(baloon);
    System.out.println(jetPlain);

    //read the file with scanner
    //add custom exceptions
    //check coords
  }
}
