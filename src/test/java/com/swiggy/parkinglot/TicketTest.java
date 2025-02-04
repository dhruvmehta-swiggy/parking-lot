package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;
import com.swiggy.parkinglot.vehicle.VehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TicketTest {

    // Test to check if the ticket is created successfully
    @Test
    public void testConstructor_WhenValidSlotAndRegistrationNumber_ThenTicketCreated() {
        Slot slot = new Slot();
        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Ticket ticket = new Ticket(slot, vehicle);
        assertNotNull(ticket);
    }

}
