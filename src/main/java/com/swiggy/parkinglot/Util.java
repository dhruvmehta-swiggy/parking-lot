package com.swiggy.parkinglot;

import com.swiggy.parkinglot.exception.*;
import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;

public class Util {

    // Method to validate the registration number
    public static void validateRegistrationNumber(String registrationNumber, String message) {
        if (registrationNumber == null || registrationNumber.isEmpty()) {
            throw new InvalidRegistrationNumberException(message);
        }
    }

    // Method to validate the slot
    public static void validateSlot(Slot slot, String message) {
        if (slot == null) {
            throw new InvalidSlotException(message);
        }
    }

    // Method to validate the vehicle
    public static void validateVehicle(Vehicle vehicle, String message) {
        if (vehicle == null) {
            throw new InvalidVehicleException(message);
        }
    }

    // Method to validate the color of the vehicle
    public static void validateVehicleColor(VehicleColor color, String message) {
        if (color == null) {
            throw new InvalidVehicleColorException(message);
        }
    }

    // Method to validate the parking lot
    public static void validateParkingLot(ParkingLot parkingLot, String message) {
        if (parkingLot == null) {
            throw new InvalidParkingLotException(message);
        }
    }

    // Method to validate the ticket
    public static void validateTicket(Ticket ticket, String message) {
        if (ticket == null) {
            throw new InvalidTicketException(message);
        }
    }

    public static void validateAttendant(Attendant attendant, String message) {
        if (attendant == null) {
            throw new InvalidAttendantException(message);
        }
    }
}
