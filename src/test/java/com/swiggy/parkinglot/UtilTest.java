package com.swiggy.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UtilTest {

    // Test to check validateRegistrationNumber method when registration number is null
    @Test
    public void testValidateRegistrationNumber_WhenRegistrationNumberIsNull_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Util.validateRegistrationNumber(null));
    }

    // Test to check validateRegistrationNumber method when registration number is empty
    @Test
    public void testValidateRegistrationNumber_WhenRegistrationNumberIsEmpty_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Util.validateRegistrationNumber(""));
    }

    // Test to check validateSlot method when slot is null
    @Test
    public void testValidateSlot_WhenSlotIsNull_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Util.validateSlot(null));
    }

    // Test to check validateVehicle method when vehicle is null
    @Test
    public void testValidateVehicle_WhenVehicleIsNull_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Util.validateVehicle(null));
    }

    // Test to check validateVehicleColor method when color is null
    @Test
    public void testValidateVehicleColor_WhenColorIsNull_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Util.validateVehicleColor(null));
    }

    // Test to check validateParkingLot method when parking lot is null
    @Test
    public void testValidateParkingLot_WhenParkingLotIsNull_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Util.validateParkingLot(null));
    }

    // Test to check validateTicket method when ticket is null
    @Test
    public void testValidateTicket_WhenTicketIsNull_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Util.validateTicket(null));
    }
}
