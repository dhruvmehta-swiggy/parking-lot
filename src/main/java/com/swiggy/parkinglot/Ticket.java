package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;

public class Ticket {

    private final ParkingLot parkingLot;
    private final Slot slot;
    private final Vehicle vehicle;

    // Constructor
    public Ticket(ParkingLot parkingLot, Slot slot, Vehicle vehicle) {
        Util.validateSlot(slot);
        Util.validateVehicle(vehicle);
        Util.validateParkingLot(parkingLot);

        this.parkingLot = parkingLot;
        this.slot = slot;
        this.vehicle = vehicle;
    }

}
