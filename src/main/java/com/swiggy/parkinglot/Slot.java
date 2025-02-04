package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
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

    public boolean isOccupied() {
        return parkedVehicle != null;
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