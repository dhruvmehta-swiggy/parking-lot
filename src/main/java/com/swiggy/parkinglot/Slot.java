package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;

import java.util.List;
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

    // Method to find the nearest slot from the entrance
    public static Slot findNearestSlot(List<Slot> slots) {
        if (slots == null || slots.isEmpty()) {
            throw new IllegalArgumentException("Slots cannot be null or empty");
        }

        Slot nearestSlot = null;
        for (Slot slot : slots) {
            if (slot.parkedVehicle == null) {
                if (nearestSlot == null || slot.distanceFromEntrance < nearestSlot.distanceFromEntrance) {
                    nearestSlot = slot;
                }
            }
        }

        return nearestSlot;
    }

    // Method to get the slot where the vehicle is parked by registration number
    public static Slot getSlotByRegistrationNumber(List<Slot> slots, String registrationNumber) {
        if (registrationNumber == null || registrationNumber.isEmpty()) {
            throw new IllegalArgumentException("Registration Number cannot be null or empty");
        }

        for (Slot slot : slots) {
            if (slot.parkedVehicle != null && slot.parkedVehicle.hasSameRegistrationNumber(registrationNumber)) {
                return slot;
            }
        }

        return null;
    }

    // Method to get number of cars with given color
    public static int fetchNumberOfCarsWithColor(List<Slot> slots, VehicleColor color) {
        if (slots == null || slots.isEmpty()) {
            throw new IllegalArgumentException("Slots cannot be null or empty");
        }

        int count = 0;
        for (Slot slot : slots) {
            if (slot.parkedVehicle != null && slot.parkedVehicle.hasSameColor(color)) {
                count++;
            }
        }

        return count;
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