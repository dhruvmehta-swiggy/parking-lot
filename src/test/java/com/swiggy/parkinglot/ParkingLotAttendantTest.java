package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;
import com.swiggy.parkinglot.vehicle.VehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    // Test to check if the ParkingLotAttendant is assigned with multiple ParkingLots without any exception
    @Test
    public void testAssign_WhenFourParkingLots_ThenNoException() {
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ParkingLot parkingLot3 = new ParkingLot(10);
        ParkingLot parkingLot4 = new ParkingLot(10);

        assertDoesNotThrow(() -> parkingLotAttendant.assign(parkingLot1));
        assertDoesNotThrow(() -> parkingLotAttendant.assign(parkingLot2));
        assertDoesNotThrow(() -> parkingLotAttendant.assign(parkingLot3));
        assertDoesNotThrow(() -> parkingLotAttendant.assign(parkingLot4));
    }

    // Test to check if the ParkingLotAttendant is able to park a vehicle and get a ticket
    @Test
    public void testPark_WhenValidVehicle_ThenNewTicket() {
        ParkingLotAttendant attendant = new ParkingLotAttendant();
        ParkingLot parkingLot = new ParkingLot(10);
        attendant.assign(parkingLot);
        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.BLUE, VehicleType.CAR);

        Ticket ticket = attendant.park(vehicle);

        assertNotNull(ticket);
    }

    // Test to check un-park method when same vehicle is parked and un-parked
    @Test
    public void testUnpark_WhenUnparkVehicle_ThenNoException() {
        ParkingLotAttendant attendant = new ParkingLotAttendant();
        ParkingLot parkingLot = new ParkingLot(10);
        attendant.assign(parkingLot);
        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.BLUE, VehicleType.CAR);
        Ticket ticket = attendant.park(vehicle);

        assertDoesNotThrow(() -> attendant.unpark(ticket));
    }

    // Test to check un-park method when a ticket is un-parked twice
    @Test
    public void testUnpark_WhenUnparkVehicleTwice_ThrowsIllegalArgumentException() {
        ParkingLotAttendant attendant = new ParkingLotAttendant();
        ParkingLot parkingLot = new ParkingLot(10);
        attendant.assign(parkingLot);
        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.BLUE, VehicleType.CAR);
        Ticket ticket = attendant.park(vehicle);
        attendant.unpark(ticket);

        assertThrows(IllegalArgumentException.class, () -> attendant.unpark(ticket));
    }
}
