package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    // List of slots in the parking lot
    private final List<Slot> slots;

    // Constructor
    public ParkingLot(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size of Parking Lot should be greater than 0");
        }

        slots = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            slots.add(new Slot());
        }
    }

    // Method to park the vehicle at the nearest slot
    public void park(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }

        Slot nearestSlot = findNearestSlot();
        if (nearestSlot == null) {
            throw new IllegalStateException("Parking Lot is full");
        }

        nearestSlot.park(vehicle);
    }

    // Method to find the nearest slot from the entrance
    private Slot findNearestSlot() {
        for (Slot slot : slots) {
            if (!slot.isOccupied()) {
                return slot;
            }
        }

        return null;
    }

    // Method to unpark the vehicle by registration number
    public void unpark(String registrationNumber) {
        Util.validateRegistrationNumber(registrationNumber);

        Slot vehicleSlot = fetchSlotByRegistrationNumber(registrationNumber);

        if (vehicleSlot == null) {
            throw new IllegalStateException("Vehicle not found in Parking Lot");
        }

        vehicleSlot.unpark();
    }

    // Method to fetch the slot where the vehicle is parked by registration number
    private Slot fetchSlotByRegistrationNumber(String registrationNumber) {
        Util.validateRegistrationNumber(registrationNumber);

        for (Slot slot : slots) {
            if (slot.isOccupied() && slot.compareParkedVehicle(registrationNumber)) {
                return slot;
            }
        }

        return null;
    }

    // Method to count the vehicles with the given color
    public int countVehiclesWithColour(VehicleColor color) {
        int count = 0;
        for (Slot slot : slots) {
            if (slot.isOccupied() && slot.compareParkedVehicle(color)) {
                count++;
            }
        }

        return count;
    }
}
