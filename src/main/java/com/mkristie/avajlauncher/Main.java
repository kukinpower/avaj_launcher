package com.mkristie.avajlauncher;

public class Main {

  public static void main(String[] args) {
    if (args.length != 1 || !args[0].endsWith(".txt")) {
      System.err.println("Please provide one and only one argument. In *.txt format");
    }
  }
}
