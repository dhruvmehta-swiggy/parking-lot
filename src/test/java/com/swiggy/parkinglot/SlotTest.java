package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleType;
import org.junit.jupiter.api.Test;

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
}
