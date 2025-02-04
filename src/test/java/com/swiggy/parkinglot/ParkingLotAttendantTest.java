package com.swiggy.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ParkingLotAttendantTest {

    // Test to check if the ParkingLotAttendant is created without any exception
    @Test
    public void testConstructor_WhenValidParkingLot_ThenNoException() {
        assertDoesNotThrow(ParkingLotAttendant::new);
    }

    // Test to check if the ParkingLotAttendant is assigned a ParkingLot without any exception
    @Test
    public void testAssign_WhenValidParkingLot_ThenNoException() {
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        ParkingLot parkingLot = new ParkingLot(10);

        assertDoesNotThrow(() -> parkingLotAttendant.assign(parkingLot));
    }
}
