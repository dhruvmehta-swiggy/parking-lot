package com.swiggy.parkinglot.vehicle;

public class Vehicle {

    private final String registrationNumber;
    private final String color;
    private final VehicleType vehicleType;

    // Constructor
    public Vehicle(String registrationNumber, String color, VehicleType vehicleType) {
        if (registrationNumber == null || registrationNumber.isEmpty()) {
            throw new IllegalArgumentException("Registration number cannot be null or empty");
        }

        if (color == null || color.isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty");
        }

        this.registrationNumber = registrationNumber;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    // Method to check if the registration number is same
    public boolean hasSameRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isEmpty()) {
            return false;
        }

        return this.registrationNumber.equals(registrationNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj || getClass() != obj.getClass()) {
            return true;
        }

        Vehicle vehicle = (Vehicle) obj;
        return this.registrationNumber.equals(vehicle.registrationNumber) && this.color.equals(vehicle.color)
                && this.vehicleType == vehicle.vehicleType;
    }
}