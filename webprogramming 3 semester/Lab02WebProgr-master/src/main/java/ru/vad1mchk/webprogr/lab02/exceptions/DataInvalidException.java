package ru.vad1mchk.webprogr.lab02.exceptions;

/**
 * Exception thrown when a number is not within range or not one of the allowed values.
 */
public class DataInvalidException extends Exception {
    public DataInvalidException() { super(); }
    public DataInvalidException(String message) { super(message); }
    public DataInvalidException(Throwable cause) { super(cause); }
    public DataInvalidException(String message, Throwable cause) { super(message, cause); }
}
