package com.swiggy.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    // Test to check equals method when different object with same values is passed
    @Test
    public void testEquals_WhenSameValues_ThenTrue() {
        ParkingLot parkingLot1 = new ParkingLot(6);
        ParkingLot parkingLot2 = new ParkingLot(6);
        assertEquals(parkingLot1, parkingLot2);
    }

    // Test to check equals method when null is passed
    @Test
    public void testEquals_WhenNull_ThenFalse() {
        ParkingLot parkingLot = new ParkingLot(6);
        assertNotEquals(null, parkingLot);
    }
}
