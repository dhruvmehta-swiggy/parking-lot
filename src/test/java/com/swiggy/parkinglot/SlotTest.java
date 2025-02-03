package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;
import com.swiggy.parkinglot.vehicle.VehicleType;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SlotTest {

    // Test to check equals method when different objects with same values are compared
    @Test
    public void testEquals_WhenSameValues_ThenTrue() {
        Slot slot1 = new Slot(1);
        Slot slot2 = new Slot(1);
        assertEquals(slot1, slot2);
    }

    // Test to check equals method when different objects are compared
    @Test
    public void testEquals_WhenDifferentObjects_ThenFalse() {
        Slot slot1 = new Slot(1);
        Slot slot2 = new Slot(2);
        assertNotEquals(slot1, slot2);
    }

    // Test to check constructor when distance is -1
    @Test
    public void testConstructor_WhenDistanceMinus1_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Slot(-1));
    }

    // Test to check constructor when distance is -3
    @Test
    public void testConstructor_WhenDistanceIsNegative_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Slot(-3));
    }

    // Test to check park method when slot is not vacant
    @Test
    public void testPark_WhenSlotIsNotVacant_ThrowsIllegalStateException() {
        Vehicle car = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Slot slot = new Slot(1);

        assertThrows(IllegalStateException.class, () -> {
            slot.park(car);
            slot.park(car);
        });
    }

    // Test to check un-park method when slot is already vacant
    @Test
    public void testUnpark_WhenSlotIsAlreadyVacant_ThrowsIllegalStateException() {
        Slot slot = new Slot(1);

        assertThrows(IllegalStateException.class, slot::unpark);
    }

    // Test to check findNearestSlot method when slots is null
    @Test
    public void testFindNearestSlot_WhenAllSlotsNull_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Slot.findNearestSlot(null));
    }

    // Test to check findNearestSlot method when all slots are vacant
    @Test
    public void testFindNearestSlot_WhenAllSlotsVacant_ThenFirstSlot() {
        List<Slot> slots = new ArrayList<>();
        Slot slot1 = new Slot(1);
        Slot slot2 = new Slot(2);

        slots.add(slot1);
        slots.add(slot2);

        Slot expected = Slot.findNearestSlot(slots);
        assertEquals(slot1, expected);
    }

    // Test to check findNearestSlot method when all slots are full
    @Test
    public void testFindNearestSlot_WhenAllSlotsFull_ThenNull() {
        List<Slot> slots = new ArrayList<>();
        Slot slot1 = new Slot(1);
        Slot slot2 = new Slot(2);
        Vehicle car1 = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Vehicle car2 = new Vehicle("KA-01-HH-1235", VehicleColor.WHITE, VehicleType.CAR);

        slot1.park(car1);
        slot2.park(car2);
        slots.add(slot1);
        slots.add(slot2);

        Slot expected = Slot.findNearestSlot(slots);
        assertNull(expected);
    }

    // Test to check fetchNumberOfCarsWithColor method when slots is null
    @Test
    public void testFetchNumberOfCarsWithColor_WhenAllSlotsNull_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Slot.fetchNumberOfCarsWithColor(null, VehicleColor.WHITE));
    }

    // Test to check fetchNumberOfCarsWithColor method when no black car is present
    @Test
    public void testFetchNumberOfCarsWithColor_WhenAllSlotsVacant_ThenZero() {
        List<Slot> slots = new ArrayList<>();
        Slot slot1 = new Slot(1);
        Slot slot2 = new Slot(2);
        Vehicle car1 = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Vehicle car2 = new Vehicle("KA-01-HH-1235", VehicleColor.BLUE, VehicleType.CAR);

        slot1.park(car1);
        slot2.park(car2);
        slots.add(slot1);
        slots.add(slot2);

        int expected = Slot.fetchNumberOfCarsWithColor(slots, VehicleColor.BLACK);
        assertEquals(0, expected);
    }

    // Test to check fetchNumberOfCarsWithColor method when two slots have white cars
    @Test
    public void testFetchNumberOfCarsWithColor_WhenTwoWhiteCars_ThenTwo() {
        List<Slot> slots = new ArrayList<>();
        Slot slot1 = new Slot(1);
        Slot slot2 = new Slot(2);
        Vehicle car1 = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Vehicle car2 = new Vehicle("KA-01-HH-1235", VehicleColor.WHITE, VehicleType.CAR);

        slot1.park(car1);
        slot2.park(car2);
        slots.add(slot1);
        slots.add(slot2);

        int expected = Slot.fetchNumberOfCarsWithColor(slots, VehicleColor.WHITE);
        assertEquals(2, expected);
    }

    // Test to check getSlotByRegistrationNumber method when registration number is null
    @Test
    public void testGetSlotByRegistrationNumber_WhenRegistrationNumberIsNull_ThrowsIllegalArgumentException() {
        // Arrange
        List<Slot> slots = new ArrayList<>();
        slots.add(new Slot(0));
        slots.add(new Slot(1));

        assertThrows(IllegalArgumentException.class, () -> Slot.getSlotByRegistrationNumber(slots, null));
    }

    // Test to check getSlotByRegistrationNumber method when registration number is empty
    @Test
    public void testGetSlotByRegistrationNumber_WhenRegistrationNumberIsEmpty_ThrowsIllegalArgumentException() {
        // Arrange
        List<Slot> slots = new ArrayList<>();
        slots.add(new Slot(0));
        slots.add(new Slot(1));

        assertThrows(IllegalArgumentException.class, () -> Slot.getSlotByRegistrationNumber(slots, ""));
    }

    // Test to check getSlotByRegistrationNumber method when registration number is not found
    @Test
    public void testGetSlotByRegistrationNumber_WhenRegistrationNumberNotFound_ThenNull() {
        // Arrange
        List<Slot> slots = new ArrayList<>();
        Slot slot1 = new Slot(0);
        Slot slot2 = new Slot(1);
        Vehicle car1 = new Vehicle("ABC123", VehicleColor.BROWN, VehicleType.CAR);
        Vehicle car2 = new Vehicle("ABC000", VehicleColor.BLACK, VehicleType.CAR);
        slot1.park(car1);
        slots.add(slot1);
        slot2.park(car2);
        slots.add(slot2);

        Slot expectedSlot = Slot.getSlotByRegistrationNumber(slots, "XYZ123");

        assertNull(expectedSlot);
    }

    // Test to check getSlotByRegistrationNumber method when registration number is found
    @Test
    public void testGetSlotByRegistrationNumber_WhenRegistrationNumberFound_ThenSlot() {
        List<Slot> slots = new ArrayList<>();
        Slot slot1 = new Slot(0);
        Slot slot2 = new Slot(1);
        Vehicle car1 = new Vehicle("ABC123", VehicleColor.BROWN, VehicleType.CAR);
        Vehicle car2 = new Vehicle("ABC000", VehicleColor.BLACK, VehicleType.CAR);
        slot1.park(car1);
        slots.add(slot1);
        slot2.park(car2);
        slots.add(slot2);

        Slot expectedSlot = Slot.getSlotByRegistrationNumber(slots, "ABC000");

        assertEquals(expectedSlot, slot2);
    }

}
