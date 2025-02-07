package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Attendant {

    // List of parking lots managed by the attendant
    private final List<ParkingLot> parkingLots;

    // Constructor
    public Attendant() {
        this.parkingLots = new ArrayList<>();
    }

    // Method to assign a parking lot to the attendant
    public void assign(ParkingLot parkingLot) {
        Util.validateParkingLot(parkingLot, "Parking Lot cannot be null");

        parkingLots.add(parkingLot);
    }

    // Method to park a vehicle in the parking lot
    public Ticket park(Vehicle vehicle) {
        Util.validateVehicle(vehicle, "Vehicle cannot be null");

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

    // Method to unpark a vehicle from the parking lot using the ticket
    public void unpark(Ticket ticket) {
        Util.validateTicket(ticket, "Ticket cannot be null");

        for (ParkingLot parkingLot : parkingLots) {
            if (ticket.hasParkingLot(parkingLot)) {
                parkingLot.unpark(ticket);
                return;
            }
        }

        throw new IllegalArgumentException("Ticket is not valid");
    }
}
