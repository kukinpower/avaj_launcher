package com.mkristie.avajlauncher.excpetion;

public class IllegalAircraftTypeException extends RuntimeException {

  private static final String MESSAGE = "There is no such aircraft type: ";

  public IllegalAircraftTypeException(String type) {
    super(MESSAGE + type);
  }
}
