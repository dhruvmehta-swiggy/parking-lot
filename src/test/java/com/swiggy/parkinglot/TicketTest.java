package com.swiggy.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TicketTest {

    // Test to check if the ticket is created successfully
    @Test
    public void testConstructor_WhenValidSlotAndRegistrationNumber_ThenTicketCreated() {
        Slot slot = new Slot();
        String registrationNumber = "KA-01-HH-1234";
        Ticket ticket = new Ticket(slot, registrationNumber);
        assertNotNull(ticket);
    }

}
