package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;
import com.swiggy.parkinglot.vehicle.VehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AttendantTest {

    // Test to check if the ParkingLotAttendant is created without any exception
    @Test
    public void testConstructor_WhenValidParkingLot_ThenNoException() {
        assertDoesNotThrow(Attendant::new);
    }

    // Test to check if the ParkingLotAttendant is assigned a ParkingLot without any exception
    @Test
    public void testAssign_WhenValidParkingLot_ThenNoException() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(10);

        assertDoesNotThrow(() -> attendant.assign(parkingLot));
    }

    // Test to check if the ParkingLotAttendant is assigned with multiple ParkingLots without any exception
    @Test
    public void testAssign_WhenFourParkingLots_ThenNoException() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        ParkingLot parkingLot3 = new ParkingLot(10);
        ParkingLot parkingLot4 = new ParkingLot(10);

        assertDoesNotThrow(() -> attendant.assign(parkingLot1));
        assertDoesNotThrow(() -> attendant.assign(parkingLot2));
        assertDoesNotThrow(() -> attendant.assign(parkingLot3));
        assertDoesNotThrow(() -> attendant.assign(parkingLot4));
    }

    // Test to check if the ParkingLotAttendant is able to park a vehicle and get a ticket
    @Test
    public void testPark_WhenValidVehicle_ThenNewTicket() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(10);
        attendant.assign(parkingLot);
        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.BLUE, VehicleType.CAR);

        Ticket ticket = attendant.park(vehicle);

        assertNotNull(ticket);
    }

    // Test to check if the ParkingLotAttendant is able to park a vehicle with multiple parking lots
    @Test
    public void testPark_WhenTwoParkingLots_ThenNewTicket() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        attendant.assign(parkingLot1);
        attendant.assign(parkingLot2);
        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.BLUE, VehicleType.CAR);

        Ticket ticket = attendant.park(vehicle);

        assertNotNull(ticket);
    }

    // Test to check un-park method when same vehicle is parked and un-parked
    @Test
    public void testUnpark_WhenUnparkVehicle_ThenNoException() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(10);
        attendant.assign(parkingLot);
        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.BLUE, VehicleType.CAR);
        Ticket ticket = attendant.park(vehicle);

        assertDoesNotThrow(() -> attendant.unpark(ticket));
    }

    // Test to check un-park method when a ticket is un-parked twice
    @Test
    public void testUnpark_WhenUnparkVehicleTwice_ThrowsIllegalArgumentException() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(10);
        attendant.assign(parkingLot);
        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.BLUE, VehicleType.CAR);
        Ticket ticket = attendant.park(vehicle);
        attendant.unpark(ticket);

        assertThrows(IllegalArgumentException.class, () -> attendant.unpark(ticket));
    }

    // Test to check un-park method when multiple vehicles and parking lots are assigned
    @Test
    public void testUnpark_WhenMultipleVehiclesAndParkingLots_ThenNoException() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        attendant.assign(parkingLot1);
        attendant.assign(parkingLot2);
        Vehicle vehicle1 = new Vehicle("KA-01-HH-1234", VehicleColor.BLUE, VehicleType.CAR);
        Vehicle vehicle2 = new Vehicle("KA-01-HH-1235", VehicleColor.BLUE, VehicleType.CAR);
        Ticket ticket1 = attendant.park(vehicle1);
        Ticket ticket2 = attendant.park(vehicle2);

        assertDoesNotThrow(() -> attendant.unpark(ticket1));
        assertDoesNotThrow(() -> attendant.unpark(ticket2));
    }
}
