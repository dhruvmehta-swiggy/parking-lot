package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;
import com.swiggy.parkinglot.vehicle.VehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {

    // Test to check if the ticket is created successfully
    @Test
    public void testConstructor_WhenValidSlotAndRegistrationNumber_ThenTicketCreated() {
        ParkingLot parkingLot = new ParkingLot(1);
        Slot slot = new Slot();
        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Ticket ticket = new Ticket(parkingLot, slot, vehicle);
        assertNotNull(ticket);
    }

    // Test to check hasParkingLot method when parking lot is same
    @Test
    public void testHasParkingLot_WhenSameParkingLot_ThenTrue() {
        ParkingLot parkingLot = new ParkingLot(1);
        Slot slot = new Slot();
        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Ticket ticket = new Ticket(parkingLot, slot, vehicle);
        assertTrue(ticket.hasParkingLot(parkingLot));
    }

    // Test to check hasParkingLot method when parking lot is different
    @Test
    public void testHasParkingLot_WhenDifferentParkingLot_ThenFalse() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Slot slot = new Slot();
        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Ticket ticket = new Ticket(parkingLot1, slot, vehicle);
        assertFalse(ticket.hasParkingLot(parkingLot2));
    }

    // Test to check hasSlot method when slot is same
    @Test
    public void testHasSlot_WhenSameSlot_ThenTrue() {
        ParkingLot parkingLot = new ParkingLot(1);
        Slot slot = new Slot();
        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Ticket ticket = new Ticket(parkingLot, slot, vehicle);
        assertTrue(ticket.hasSlot(slot));
    }

    // Test to check hasSlot method when slot is different
    @Test
    public void testHasSlot_WhenDifferentSlot_ThenFalse() {
        ParkingLot parkingLot = new ParkingLot(1);
        Slot slot1 = new Slot();
        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        slot1.park(vehicle);
        Ticket ticket = new Ticket(parkingLot, slot1, vehicle);
        Slot slot2 = new Slot();
        assertFalse(ticket.hasSlot(slot2));
    }
}
