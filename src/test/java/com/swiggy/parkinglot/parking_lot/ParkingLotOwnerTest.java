package com.swiggy.parkinglot.parking_lot;

import com.swiggy.parkinglot.Attendant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotOwnerTest {

    // Test to check constructor
    @Test
    public void testConstructor_WhenNewParkingLotOwner_ThenNotNull() {
        assertDoesNotThrow(ParkingLotOwner::new);
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        assertNotNull(parkingLotOwner);
    }

    // Test to check addParkingLot method when one parking lot
    @Test
    public void testAddParkingLot_WhenOneParkingLot_ThenNoException() {
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(10);
        assertDoesNotThrow(() -> parkingLotOwner.addParkingLot(parkingLot));
    }

    // Test to check addParkingLot method when three parking lots
    @Test
    public void testAddParkingLot_WhenThreeParkingLots_ThenNoException() {
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(20);
        ParkingLot parkingLot3 = new ParkingLot(30);
        assertDoesNotThrow(() -> parkingLotOwner.addParkingLot(parkingLot1));
        assertDoesNotThrow(() -> parkingLotOwner.addParkingLot(parkingLot2));
        assertDoesNotThrow(() -> parkingLotOwner.addParkingLot(parkingLot3));
    }

    // Test to check assignAttendant method when one attendant
    @Test
    public void testAssignAttendant_WhenOneAttendant_ThenNoException() {
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        ParkingLot parkingLot = new ParkingLot(10);
        parkingLotOwner.addParkingLot(parkingLot);
        Attendant attendant = new Attendant();
        assertDoesNotThrow(() -> parkingLotOwner.assignAttendant(attendant));
    }

    // Test to check assignAttendant method when four attendants
    @Test
    public void testAssignAttendant_WhenFourAttendants_ThenNoException() {
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner();
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(20);
        ParkingLot parkingLot3 = new ParkingLot(30);
        ParkingLot parkingLot4 = new ParkingLot(40);
        parkingLotOwner.addParkingLot(parkingLot1);
        parkingLotOwner.addParkingLot(parkingLot2);
        parkingLotOwner.addParkingLot(parkingLot3);
        parkingLotOwner.addParkingLot(parkingLot4);
        Attendant attendant = new Attendant();
        assertDoesNotThrow(() -> parkingLotOwner.assignAttendant(attendant));
    }
}
