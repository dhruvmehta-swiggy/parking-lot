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
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }

        Slot nearestSlot = Slot.findNearestSlot(this.slots);
        if (nearestSlot == null) {
            throw new IllegalStateException("Parking Lot is full");
        }

        nearestSlot.park(vehicle);
    }

    // Method to un-park the vehicle from the slot
    public void unpark_Vehicle(Vehicle vehicle) {
        Slot vehicleSlot = Slot.getVehicleSlot(this.slots, vehicle);

        if (vehicleSlot == null) {
            throw new IllegalStateException("Vehicle not found in Parking Lot");
        }

        vehicleSlot.unpark();
    }

    // Method to unpark the vehicle by registration number
    public void unpark_RegistrationNumber(String registrationNumber) {
        Slot vehicleSlot = Slot.getVehicleByRegistrationNumber(this.slots, registrationNumber);

        if (vehicleSlot == null) {
            throw new IllegalStateException("Vehicle not found in Parking Lot");
        }

        vehicleSlot.unpark();
    }
}
