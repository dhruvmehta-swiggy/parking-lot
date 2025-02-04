package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;
import com.swiggy.parkinglot.vehicle.VehicleType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SlotTest {

    // Test to check park method when slot is not vacant
    @Test
    public void testPark_WhenSlotIsOccupied_ThrowsIllegalStateException() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Slot slot = new Slot();

        assertThrows(IllegalStateException.class, () -> {
            slot.park(car);
            slot.park(car);
        });
    }

    // Test to check un-park method when slot is already vacant
    @Test
    public void testUnpark_WhenSlotIsAlreadyVacant_ThrowsIllegalStateException() {
        Slot slot = new Slot();

        assertThrows(IllegalStateException.class, slot::unpark);
    }

    // Test to check isVehicleWithRegistrationNumber method when vehicle is not parked
    @Test
    public void testIsVehicleWithRegistrationNumber_WhenVehicleNotParked_ThenFalse() {
        Slot slot = new Slot();

        String registrationNumber = "KA-01-HH-1234";
        assertFalse(slot.isVehicleWithRegistrationNumber(registrationNumber));
    }

    // Test to check isVehicleWithRegistrationNumber method when registration number is same
    @Test
    public void testIsVehicleWithRegistrationNumber_WhenSameRegistrationNumber_ThenTrue() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Slot slot = new Slot();
        slot.park(car);

        String expectedRegistrationNumber = "KA-01-HH-1234";
        assertTrue(slot.isVehicleWithRegistrationNumber(expectedRegistrationNumber));
    }

    // Test to check isVehicleWithRegistrationNumber method when registration number is different
    @Test
    public void testIsVehicleWithRegistrationNumber_WhenDifferentRegistrationNumber_ThenFalse() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Slot slot = new Slot();
        slot.park(car);

        String expectedRegistrationNumber = "KA-01-HH-1235";
        assertFalse(slot.isVehicleWithRegistrationNumber(expectedRegistrationNumber));
    }

    // Test to check equals method when different objects with same values are compared
    @Test
    public void testEquals_WhenSameValues_ThenTrue() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Slot slot1 = new Slot();
        slot1.park(car);
        Slot slot2 = new Slot();
        slot2.park(car);

        assertEquals(slot1, slot2);
    }

    // Test to check isVehicleWithColor method when vehicle is not parked
    @Test
    public void testIsVehicleWithColor_WhenVehicleNotParked_ThenFalse() {
        Slot slot = new Slot();

        VehicleColor expectedColor = VehicleColor.WHITE;
        assertFalse(slot.isVehicleWithColor(expectedColor));
    }

    // Test to check isVehicleWithColor method when color is same
    @Test
    public void testIsVehicleWithColor_WhenSameColor_ThenTrue() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Slot slot = new Slot();
        slot.park(car);

        VehicleColor expectedColor = VehicleColor.WHITE;
        assertTrue(slot.isVehicleWithColor(expectedColor));
    }

    // Test to check isVehicleWithColor method when color is different
    @Test
    public void testIsVehicleWithColor_WhenDifferentColor_ThenFalse() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Slot slot = new Slot();
        slot.park(car);

        VehicleColor expectedColor = VehicleColor.BLACK;
        assertFalse(slot.isVehicleWithColor(expectedColor));
    }

    // Test to check equals method when different objects are compared
    @Test
    public void testEquals_WhenDifferentObjects_ThenFalse() {
        Vehicle car1 = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Slot slot1 = new Slot();
        slot1.park(car1);
        Vehicle car2 = new Vehicle("KA-01-HH-1235", VehicleColor.BLACK, VehicleType.CAR);
        Slot slot2 = new Slot();
        slot2.park(car2);

        assertNotEquals(slot1, slot2);
    }

}
