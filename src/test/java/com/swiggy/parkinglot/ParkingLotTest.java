package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
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
    public void testParkAtNearestSlot_WhenVehicleIsNull_ThenIllegalArgumentException() {
        ParkingLot parkingLot = new ParkingLot(2);

        assertThrows(IllegalArgumentException.class, () -> parkingLot.parkAtNearestSlot(null));
    }

    // Test to check parkAtNearestSlot method when all slots are full
    @Test
    public void testParkAtNearestSlot_WhenAllSlotsFull_ThenIllegalStateException() {
        ParkingLot parkingLot = new ParkingLot(2);

        parkingLot.parkAtNearestSlot(new Vehicle("KA-01-HH-1234", "White", VehicleType.CAR));
        parkingLot.parkAtNearestSlot(new Vehicle("KA-01-HH-1235", "White", VehicleType.CAR));

        assertThrows(IllegalStateException.class, () -> parkingLot.parkAtNearestSlot(new Vehicle("KA-01-HH-1236", "White", VehicleType.CAR)));
    }

    // Test to check unpark method when vehicle is not found
    @Test
    public void testUnpark_Vehicle_WhenVehicleNotFound_ThenIllegalStateException() {
        ParkingLot parkingLot = new ParkingLot(2);

        parkingLot.parkAtNearestSlot(new Vehicle("KA-01-HH-1234", "White", VehicleType.CAR));
        parkingLot.parkAtNearestSlot(new Vehicle("KA-01-HH-1235", "White", VehicleType.CAR));

        assertThrows(IllegalStateException.class, () -> parkingLot.unpark_Vehicle(new Vehicle("KA-01-HH-1236", "White", VehicleType.CAR)));
    }
}
