package com.swiggy.parkinglot.vehicle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {

    // Test to check equals method when input is null
    @Test
    public void testEquals_WhenNull_ThenFalse() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        assertNotEquals(null, car);
    }

    // Test to check equals method when objects with same value are passed
    @Test
    public void testEquals_WhenSameObject_ThenTrue() {
        Vehicle car1 = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Vehicle car2 = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        assertEquals(car1, car2);
    }

    // Test to check equals method when different object is passed
    @Test
    public void testEquals_WhenDifferentObject_ThenFalse() {
        Vehicle car1 = new Vehicle("1234", VehicleColor.WHITE, VehicleType.CAR);
        Vehicle car2 = new Vehicle("1000", VehicleColor.BLACK, VehicleType.CAR);
        assertNotEquals(car1, car2);
    }

    // Test to check constructor when valid input is passed
    @Test
    public void testConstructor_WhenValidInput_ThenObjectCreated() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        assertNotNull(car);
    }

    // Test to check constructor when null registration number is passed
    @Test
    public void testConstructor_WhenNullRegistrationNumber_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Vehicle(null, VehicleColor.WHITE, VehicleType.CAR));
    }

    // Test to check constructor when empty registration number is passed
    @Test
    public void testConstructor_WhenEmptyRegistrationNumber_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Vehicle("", VehicleColor.WHITE, VehicleType.CAR));
    }

    // Test to check constructor when null color is passed
    @Test
    public void testConstructor_WhenNullColor_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Vehicle("KA-01-HH-1234", null, VehicleType.CAR));
    }

    // Test to check hasSameRegistrationNumber method when null registration number is passed
    @Test
    public void testHasSameRegistrationNumber_WhenNullRegistrationNumber_ThenFalse() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        assertFalse(car.hasSameRegistrationNumber(null));
    }

    // Test to check hasSameRegistrationNumber method when empty registration number is passed
    @Test
    public void testHasSameRegistrationNumber_WhenEmptyRegistrationNumber_ThenFalse() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        assertFalse(car.hasSameRegistrationNumber(""));
    }

    // Test to check hasSameRegistrationNumber method when same registration number is passed
    @Test
    public void testHasSameRegistrationNumber_WhenSameRegistrationNumber_ThenTrue() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        assertTrue(car.hasSameRegistrationNumber("KA-01-HH-1234"));
    }

    // Test to check hasSameRegistrationNumber method when different registration number is passed
    @Test
    public void testHasSameRegistrationNumber_WhenDifferentRegistrationNumber_ThenFalse() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        assertFalse(car.hasSameRegistrationNumber("KA-01-HH-1000"));
    }

    // Test to check hasSameColor method when null color is passed
    @Test
    public void testHasSameColor_WhenNullColor_ThenFalse() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        assertFalse(car.hasSameColor(null));
    }

    // Test to check hasSameColor method when same color is passed
    @Test
    public void testHasSameColor_WhenSameColor_ThenTrue() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        assertTrue(car.hasSameColor(VehicleColor.WHITE));
    }

    // Test to check hasSameColor method when different color is passed
    @Test
    public void testHasSameColor_WhenDifferentColor_ThenFalse() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        assertFalse(car.hasSameColor(VehicleColor.BLACK));
    }
}
