package com.swiggy.parkinglot.parking_lot;

import com.swiggy.parkinglot.Attendant;
import com.swiggy.parkinglot.Util;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotOwner extends Attendant {
    private final List<ParkingLot> parkingLots;

    // Constructor
    public ParkingLotOwner() {
        super();
        parkingLots = new ArrayList<>();
    }

    // Method to add parking lot to the owner
    public void addParkingLot(ParkingLot parkingLot) {
        Util.validateParkingLot(parkingLot, "Parking Lot cannot be null");
        parkingLots.add(parkingLot);
        super.assign(parkingLot);
    }

    // Method to assign attendants to all parking lots
    public void assignAttendant(Attendant attendant) {
        Util.validateAttendant(attendant, "Attendant cannot be null");
        for (ParkingLot parkingLot : parkingLots) {
            parkingLot.assignAttendant(attendant);
        }
    }
}
