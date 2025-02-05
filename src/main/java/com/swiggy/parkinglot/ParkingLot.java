package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    // List of slots in the parking lot
    private final List<Slot> slots;

    // Constructor
    public ParkingLot(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size of Parking Lot should be greater than 0");
        }

        slots = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            slots.add(new Slot());
        }
    }

    // Method to park the vehicle at a given location
    public Ticket park(Vehicle vehicle, int location) {
        Util.validateVehicle(vehicle, "Vehicle cannot be null");
        Slot nearestSlot = slots.get(location);
        nearestSlot.park(vehicle);
        Util.validateSlot(nearestSlot, "Unable to park vehicle at null slot");

        return new Ticket(this, nearestSlot, vehicle);
    }

    // Method to find the nearest slot by location
    protected int findLocationOfNearestSlot(){
        for (int i = 0; i < slots.size(); i++) {
            if (!slots.get(i).isOccupied()) {
                return i;
            }
        }

        return -1;
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
