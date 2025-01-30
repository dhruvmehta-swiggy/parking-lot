package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;

import java.util.Objects;

public class Slot {
    private final int distanceFromEntrance;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    public Slot(int distanceFromEntrance) {
        if (distanceFromEntrance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative");
        }

        this.distanceFromEntrance = distanceFromEntrance;
        this.isOccupied = false;
        this.parkedVehicle = null;
    }

    // Method to park a vehicle in the current slot
    public void park(Vehicle vehicle) {
        if (isOccupied) {
            throw new IllegalStateException("Slot is not available");
        }

        isOccupied = true;
        parkedVehicle = vehicle;
    }

    // Method to un-park a vehicle from the current slot
    public void unpark() {
        if (!isOccupied) {
            throw new IllegalStateException("Slot is already vacant");
        }

        isOccupied = false;
        parkedVehicle = null;
    }

    public boolean getStatus() {
        return isOccupied;
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
        return distanceFromEntrance == slot.distanceFromEntrance && isOccupied == slot.isOccupied && Objects.equals(parkedVehicle, slot.parkedVehicle);
    }
}
