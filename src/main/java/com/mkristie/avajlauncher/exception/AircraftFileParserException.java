package com.mkristie.avajlauncher.exception;

public class AircraftFileParserException extends IllegalArgumentException {

  private static final String MESSAGE_PREFIX = "Check input file: ";

  public AircraftFileParserException(Exception e) {
    super(MESSAGE_PREFIX + e.getMessage(), e.getCause());
  }
}
