package com.swiggy.parkinglot.exception;

public class InvalidRegistrationNumberException extends RuntimeException {
    public InvalidRegistrationNumberException(String message) {
        super(message);
    }
}
