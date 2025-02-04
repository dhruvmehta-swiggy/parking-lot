package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;
import com.swiggy.parkinglot.vehicle.VehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    // Test to check constructor when input is 5
    @Test
    public void testConstructor_WhenInputIs5_ThenSizeIs5() {
        ParkingLot parkingLot = new ParkingLot(5);
        assertNotNull(parkingLot);
    }

    // Test to check constructor when input is 0
    @Test
    public void testConstructor_WhenInputIs0_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new ParkingLot(0));
    }

    // Test to check constructor when input is -3
    @Test
    public void testConstructor_WhenInputIsNegative_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new ParkingLot(-3));
    }

    // Test to check parkAtNearestSlot method when vehicle is null
    @Test
    public void testPark_WhenVehicleIsNull_ThrowIllegalArgumentException() {
        ParkingLot parkingLot = new ParkingLot(2);

        // Park a null vehicle
        assertThrows(IllegalArgumentException.class, () -> parkingLot.park(null));
    }

    // Test to check parkAtNearestSlot method when all slots are full
    @Test
    public void testPark_NoEmptySlot_ThrowIllegalStateException() {
        ParkingLot parkingLot = new ParkingLot(2);

        parkingLot.park(new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR));
        parkingLot.park(new Vehicle("KA-01-HH-1235", VehicleColor.WHITE, VehicleType.CAR));

        // Park another vehicle when all slots are full
        assertThrows(IllegalStateException.class, () -> parkingLot.park(new Vehicle("KA-01-HH-1236", VehicleColor.WHITE, VehicleType.CAR)));
    }

    // Test to check unpark method when registration number is not found
    @Test
    public void testUnpark_WhenRegistrationNumberIsNotFound_ThrowIllegalStateException() {
        ParkingLot parkingLot = new ParkingLot(2);

        parkingLot.park(new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR));
        parkingLot.park(new Vehicle("KA-01-HH-1235", VehicleColor.WHITE, VehicleType.CAR));

        String registrationNumber = "KA-01-HH-1236";
        assertThrows(IllegalStateException.class, () -> parkingLot.unpark(registrationNumber));
    }

    // Test to check unpark method when registration number is found
    @Test
    public void testUnpark_WhenRegistrationNumberIsFound_ThenEmptySlot() {
        ParkingLot parkingLot = new ParkingLot(2);

        Vehicle vehicle1 = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Vehicle vehicle2 = new Vehicle("KA-01-HH-1235", VehicleColor.WHITE, VehicleType.CAR);

        parkingLot.park(vehicle1);
        parkingLot.park(vehicle2);

        // Unpark the vehicle once
        parkingLot.unpark("KA-01-HH-1234");

        // Unpark the same vehicle again
        assertThrows(IllegalStateException.class, () -> parkingLot.unpark("KA-01-HH-1234"));
    }
}
