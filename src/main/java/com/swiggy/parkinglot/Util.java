package com.swiggy.parkinglot;

public class Util {

    // Method to validate the registration number
    public static void validateRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isEmpty()) {
            throw new IllegalArgumentException("Registration Number cannot be null or empty");
        }
    }
}
