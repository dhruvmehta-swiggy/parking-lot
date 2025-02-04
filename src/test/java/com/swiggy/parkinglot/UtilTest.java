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
}
