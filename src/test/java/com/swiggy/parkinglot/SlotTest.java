package com.swiggy.parkinglot;

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

    // Test to check constructor when distance is 0
    @Test
    public void testConstructor_WhenDistanceIsZero_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Slot(0));
    }

    // Test to check constructor when distance is -3
    @Test
    public void testConstructor_WhenDistanceIsNegative_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new Slot(-3));
    }
}
