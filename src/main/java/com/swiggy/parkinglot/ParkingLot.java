package com.swiggy.parkinglot;

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

    // Method to find the nearest slot
    public Slot findNearestSlot() {
        for (Slot slot : slots) {
            if (slot.getStatus() == SlotStatus.VACANT) {
                return slot;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ParkingLot parkingLot = (ParkingLot) obj;
        return slots.equals(parkingLot.slots);
    }
}
