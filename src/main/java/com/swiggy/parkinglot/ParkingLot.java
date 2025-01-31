package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;

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
            slots.add(new Slot(i));
        }
    }

    // Method to park the vehicle at the nearest slot
    public void parkAtNearestSlot(Vehicle vehicle) {
        for (Slot slot : slots) {
            if (!slot.isOccupied()) {
                slot.park(vehicle);
                return;
            }
        }

        throw new IllegalStateException("Parking Lot is full");
    }
}
