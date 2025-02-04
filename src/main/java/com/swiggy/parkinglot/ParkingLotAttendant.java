package com.swiggy.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotAttendant {

    // List of parking lots managed by the attendant
    private List<ParkingLot> parkingLots;

    // Constructor
    public ParkingLotAttendant() {
        this.parkingLots = new ArrayList<>();
    }

    // Method to assign a parking lot to the attendant
    public void assign(ParkingLot parkingLot) {
        Util.validateParkingLot(parkingLot);

        parkingLots.add(parkingLot);
    }
}
