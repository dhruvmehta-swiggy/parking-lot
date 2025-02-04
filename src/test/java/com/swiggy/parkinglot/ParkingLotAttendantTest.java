package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;
import com.swiggy.parkinglot.vehicle.VehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
