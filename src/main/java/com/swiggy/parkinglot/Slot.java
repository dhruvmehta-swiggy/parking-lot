package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;

import java.util.Objects;

public class Slot {
    private final int distanceFromEntrance;
    private Vehicle parkedVehicle;

    public Slot(int distanceFromEntrance) {
        if (distanceFromEntrance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative");
        }

        this.distanceFromEntrance = distanceFromEntrance;
        this.parkedVehicle = null;
    }

    // Method to return if the slot is occupied
    public boolean isOccupied() {
        return parkedVehicle != null;
    }

    // Method to park a vehicle in the current slot
    public void park(Vehicle vehicle) {
        if (parkedVehicle != null) {
            throw new IllegalStateException("Slot is not available");
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Slot slot = (Slot) obj;
        return distanceFromEntrance == slot.distanceFromEntrance && Objects.equals(parkedVehicle, slot.parkedVehicle);
    }
}
