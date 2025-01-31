package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
        Vehicle car = new Vehicle("KA-01-HH-1234", "White", VehicleType.CAR);
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
        Slot slot1 = new Slot(1);
        Slot slot2 = new Slot(2);

        Map<Slot, Vehicle> slots = new HashMap<>();
        slots.put(slot1, null);
        slots.put(slot2, null);

        Slot expected = Slot.findNearestSlot(slots);
        assertEquals(slot1, expected);
    }

    // Test to check findNearestSlot method when all slots are full
    @Test
    public void testFindNearestSlot_WhenAllSlotsFull_ThenNull() {
        Slot slot1 = new Slot(1);
        Slot slot2 = new Slot(2);

        Map<Slot, Vehicle> slots = new HashMap<>();
        slots.put(slot1, new Vehicle("KA-01-HH-1234", "White", VehicleType.CAR));
        slots.put(slot2, new Vehicle("KA-01-HH-1235", "White", VehicleType.CAR));

        Slot expected = Slot.findNearestSlot(slots);
        assertNull(expected);
    }
}
