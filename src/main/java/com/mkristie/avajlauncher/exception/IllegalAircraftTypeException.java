package com.mkristie.avajlauncher.exception;

public class IllegalAircraftTypeException extends RuntimeException {

  private static final String MESSAGE = "There is no such aircraft type: ";

  public IllegalAircraftTypeException(String type) {
    super(MESSAGE + type);
  }
}
