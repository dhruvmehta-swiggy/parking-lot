package com.swiggy.parkinglot.parking_lot;

import com.swiggy.parkinglot.Attendant;
import com.swiggy.parkinglot.Slot;
import com.swiggy.parkinglot.Ticket;
import com.swiggy.parkinglot.Util;
import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    // List of slots in the parking lot
    private final List<Slot> slots;
    private final List<Attendant> attendants;

    // Constructor
    public ParkingLot(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size of Parking Lot should be greater than 0");
        }

        slots = new ArrayList<>(size);
        attendants = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            slots.add(new Slot());
        }
    }

    // Method to assign attendants
    public void assignAttendant(Attendant attendant) {
        Util.validateAttendant(attendant, "Attendant cannot be null");
        attendants.add(attendant);
    }

    // Method to park the vehicle at a given location
    public Ticket park(Vehicle vehicle) {
        Util.validateVehicle(vehicle, "Vehicle cannot be null");

        for (Slot slot : slots) {
            if (!slot.isOccupied()) {
                slot.park(vehicle);
                return new Ticket(this, slot, vehicle);
            }
        }

        throw new IllegalStateException("Parking Lot is full");
    }

    // Method to unpark the vehicle using the ticket
    public void unpark(Ticket ticket) {
        Util.validateTicket(ticket, "Ticket cannot be null");

        for (Slot slot : slots) {
            if (slot.isOccupied() && ticket.hasSlot(slot)) {
                slot.unpark();
                return;
            }
        }

        throw new IllegalArgumentException("Ticket does not belong to any slot in the parking lot");
    }

    // Method to count the vehicles with the given color
    public int countVehiclesWithColour(VehicleColor color) {
        int count = 0;
        for (Slot slot : slots) {
            if (slot.isOccupied() && slot.compareParkedVehicle(color)) {
                count++;
            }
        }

        return count;
    }
}
