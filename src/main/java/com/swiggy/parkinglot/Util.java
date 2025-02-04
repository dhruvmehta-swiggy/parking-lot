package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;

public class Util {

    // Method to validate the registration number
    public static void validateRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isEmpty()) {
            throw new IllegalArgumentException("Registration Number cannot be null or empty");
        }
    }

    // Method to validate the slot
    public static void validateSlot(Slot slot) {
        if (slot == null) {
            throw new IllegalArgumentException("Slot cannot be null");
        }
    }

    // Method to validate the vehicle
    public static void validateVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
    }

    // Method to validate the color of the vehicle
    public static void validateVehicleColor(VehicleColor color) {
        if (color == null) {
            throw new IllegalArgumentException("Vehicle Color cannot be null");
        }
    }

    // Method to validate the parking lot
    public static void validateParkingLot(ParkingLot parkingLot) {
        if (parkingLot == null) {
            throw new IllegalArgumentException("Parking Lot cannot be null");
        }
    }
}
