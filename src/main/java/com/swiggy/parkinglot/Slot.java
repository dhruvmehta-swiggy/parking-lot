package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;

import java.util.Objects;

public class Slot {
    private Vehicle parkedVehicle;

    public Slot() {
        this.parkedVehicle = null;
    }

    // Method to park a vehicle in the current slot
    public void park(Vehicle vehicle) {
        if (parkedVehicle != null) {
            throw new IllegalStateException("Slot is already occupied");
        }

        parkedVehicle = vehicle;
    }

    // Method to un-park a vehicle from the current slot
    public void unpark() {
        if (parkedVehicle == null) {
            throw new IllegalStateException("Slot is already vacant");
        }

        parkedVehicle = null;
    }
    
    // Method to check if the slot is occupied
    public boolean isOccupied() {
        return parkedVehicle != null;
    }

    // Method to compare the registration number of the parked vehicle
    public boolean isVehicleWithRegistrationNumber(String registrationNumber) {
        if (parkedVehicle == null) {
            return false;
        }

        Util.validateRegistrationNumber(registrationNumber);

        return parkedVehicle.hasSameRegistrationNumber(registrationNumber);
    }

    // Method to get the parked vehicle
    public boolean isVehicleWithColor(VehicleColor color) {
        if (parkedVehicle == null) {
            return false;
        }

        return parkedVehicle.hasSameColor(color);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Slot slot = (Slot) obj;
        return Objects.equals(parkedVehicle, slot.parkedVehicle);
    }
}