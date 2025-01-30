package com.swiggy.parkinglot.vehicle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    // Test to check equals method when input is null
    @Test
    public void testEquals_WhenNull_ThenFalse() {
        Vehicle car = new Vehicle("KA-01-HH-1234", "White", VehicleType.CAR);
        assertNotEquals(null, car);
    }

    // Test to check equals method when objects with same value are passed
    @Test
    public void testEquals_WhenSameObject_ThenTrue() {
        Vehicle car1 = new Vehicle("KA-01-HH-1234", "White", VehicleType.CAR);
        Vehicle car2 = new Vehicle("KA-01-HH-1234", "White", VehicleType.CAR);
        assertEquals(car1, car2);
    }

    // Test to check equals method when different object is passed
    @Test
    public void testEquals_WhenDifferentObject_ThenFalse() {
        Vehicle car1 = new Vehicle("1234", "White", VehicleType.CAR);
        Vehicle car2 = new Vehicle("1000", "Black", VehicleType.CAR);
        assertNotEquals(car1, car2);
    }

    // Test to check constructor when valid input is passed
    @Test
    public void testConstructor_WhenValidInput_ThenObjectCreated() {
        Vehicle car = new Vehicle("KA-01-HH-1234", "White", VehicleType.CAR);
        assertNotNull(car);
    }

    // Test to check constructor when null registration number is passed
    @Test
    public void testConstructor_WhenNullRegistrationNumber_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Vehicle(null, "White", VehicleType.CAR));
    }

    // Test to check constructor when empty registration number is passed
    @Test
    public void testConstructor_WhenEmptyRegistrationNumber_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Vehicle("", "White", VehicleType.CAR));
    }

    // Test to check constructor when null color is passed
    @Test
    public void testConstructor_WhenNullColor_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Vehicle("KA-01-HH-1234", null, VehicleType.CAR));
    }

    // Test to check constructor when empty color is passed
    @Test
    public void testConstructor_WhenEmptyColor_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Vehicle("KA-01-HH-1234", "", VehicleType.CAR));
    }
}
