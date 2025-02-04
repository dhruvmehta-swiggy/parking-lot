package com.swiggy.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ParkingLotAttendantTest {

    // Test to check if the ParkingLotAttendant is created without any exception
    @Test
    public void testConstructor_WhenValidParkingLot_ThenNoException() {
        assertDoesNotThrow(ParkingLotAttendant::new);
    }

}
