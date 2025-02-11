package com.swiggy.parkinglot;

import com.swiggy.parkinglot.exception.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UtilTest {

    // Test to check validateRegistrationNumber method when registration number is null
    @Test
    public void testValidateRegistrationNumber_WhenRegistrationNumberIsNull_ThrowIllegalArgumentException() {
        assertThrows(InvalidRegistrationNumberException.class, () -> Util.validateRegistrationNumber(null, ""));
    }

    // Test to check validateRegistrationNumber method when registration number is empty
    @Test
    public void testValidateRegistrationNumber_WhenRegistrationNumberIsEmpty_ThrowIllegalArgumentException() {
        assertThrows(InvalidRegistrationNumberException.class, () -> Util.validateRegistrationNumber("", ""));
    }

    // Test to check validateSlot method when slot is null
    @Test
    public void testValidateSlot_WhenSlotIsNull_ThrowIllegalArgumentException() {
        assertThrows(InvalidSlotException.class, () -> Util.validateSlot(null, ""));
    }

    // Test to check validateVehicle method when vehicle is null
    @Test
    public void testValidateVehicle_WhenVehicleIsNull_ThrowIllegalArgumentException() {
        assertThrows(InvalidVehicleException.class, () -> Util.validateVehicle(null, ""));
    }

    // Test to check validateVehicleColor method when color is null
    @Test
    public void testValidateVehicleColor_WhenColorIsNull_ThrowIllegalArgumentException() {
        assertThrows(InvalidVehicleColorException.class, () -> Util.validateVehicleColor(null, ""));
    }

    // Test to check validateParkingLot method when parking lot is null
    @Test
    public void testValidateParkingLot_WhenParkingLotIsNull_ThrowIllegalArgumentException() {
        assertThrows(InvalidParkingLotException.class, () -> Util.validateParkingLot(null, "Parking Lot cannot be null"));
    }

    // Test to check validateTicket method when ticket is null
    @Test
    public void testValidateTicket_WhenTicketIsNull_ThrowIllegalArgumentException() {
        assertThrows(InvalidTicketException.class, () -> Util.validateTicket(null, "Ticket cannot be null"));
    }

    // Test to check validateAttendant method when attendant is null
    @Test
    public void testValidateAttendant_WhenAttendantIsNull_ThrowIllegalArgumentException() {
        assertThrows(InvalidAttendantException.class, () -> Util.validateAttendant(null, "Attendant cannot be null"));
    }
}
