package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;

public class Ticket {

    private final ParkingLot parkingLot;
    private final Slot slot;
    private final Vehicle vehicle;

    // Constructor
    public Ticket(ParkingLot parkingLot, Slot slot, Vehicle vehicle) {
        Util.validateSlot(slot, "Slot cannot be null");
        Util.validateVehicle(vehicle, "Vehicle cannot be null");
        Util.validateParkingLot(parkingLot, "Parking Lot cannot be null");

        this.parkingLot = parkingLot;
        this.slot = slot;
        this.vehicle = vehicle;
    }

    // Method to compare the parking lot
    public boolean hasParkingLot(ParkingLot parkingLot) {
        return this.parkingLot.equals(parkingLot);
    }

    // Method to compare the slot
    public boolean hasSlot(Slot slot) {
        return this.slot.equals(slot);
    }
}
