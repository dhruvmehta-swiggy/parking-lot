package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;

import java.util.Objects;

public class Slot {
    private final int distanceFromEntrance;
    private final int floor;
    private final SlotStatus slotStatus;
    private final Vehicle parkedVehicle;

    public Slot(int distanceFromEntrance) {
        if (distanceFromEntrance <= 0) {
            throw new IllegalArgumentException("Distance should be greater than 0");
        }

        this.distanceFromEntrance = distanceFromEntrance;
        this.floor = 0;
        this.slotStatus = SlotStatus.VACANT;
        this.parkedVehicle = null;
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
        return distanceFromEntrance == slot.distanceFromEntrance && floor == slot.floor && slotStatus == slot.slotStatus && Objects.equals(parkedVehicle, slot.parkedVehicle);
    }
}
