package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;

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

    // Method to park a vehicle in the parking lot
    public Ticket park(Vehicle vehicle) {
        Util.validateVehicle(vehicle);

        ParkingLot nearestParkingLot = null;
        int nearestSlotLocation = Integer.MAX_VALUE;

        // Find location of the nearest parking slot in the parking lots
        for (ParkingLot parkingLot : parkingLots) {
            int temp = parkingLot.findLocationOfNearestSlot();
            if (temp < nearestSlotLocation) {
                nearestParkingLot = parkingLot;
                nearestSlotLocation = temp;
            }
        }

        if (nearestParkingLot == null) {
            throw new IllegalStateException("All parking lots are full");
        }

        return nearestParkingLot.park(vehicle, nearestSlotLocation);
    }
}
