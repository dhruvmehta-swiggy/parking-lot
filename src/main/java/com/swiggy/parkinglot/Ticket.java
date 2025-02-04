package com.swiggy.parkinglot;

public class Ticket {

    private final Slot slot;
    private final String registrationNumber;

    // Constructor
    public Ticket(Slot slot, String registrationNumber) {
        Util.validateSlot(slot);
        Util.validateRegistrationNumber(registrationNumber);

        this.slot = slot;
        this.registrationNumber = registrationNumber;
    }

}
