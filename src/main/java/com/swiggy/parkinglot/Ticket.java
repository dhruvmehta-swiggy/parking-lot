package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;

public class Ticket {

    private final Slot slot;
    private final Vehicle vehicle;

    // Constructor
    public Ticket(Slot slot, Vehicle vehicle) {
        Util.validateSlot(slot);
        Util.validateVehicle(vehicle);

        this.slot = slot;
        this.vehicle = vehicle;
    }

}
