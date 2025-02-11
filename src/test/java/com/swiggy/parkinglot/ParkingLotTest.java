package com.swiggy.parkinglot;

import com.swiggy.parkinglot.vehicle.Vehicle;
import com.swiggy.parkinglot.vehicle.VehicleColor;
import com.swiggy.parkinglot.vehicle.VehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    // Test to check constructor when input is 5
    @Test
    public void testConstructor_WhenInputIs5_ThenSizeIs5() {
        ParkingLot parkingLot = new ParkingLot(5);
        assertNotNull(parkingLot);
    }

    // Test to check constructor when input is 0
    @Test
    public void testConstructor_WhenInputIs0_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new ParkingLot(0));
    }

    // Test to check constructor when input is -3
    @Test
    public void testConstructor_WhenInputIsNegative_ThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new ParkingLot(-3));
    }

    // Test to check assignAttendant method when attendant is valid
    @Test
    public void testAssignAttendant_WhenOneAttendant_ThenAssign() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(2);

        assertDoesNotThrow(() -> parkingLot.assignAttendant(attendant));
    }

    // Test to check assignAttendant method when three attendants are assigned
    @Test
    public void testAssignAttendant_WhenThreeAttendants_ThenAssign() {
        Attendant attendant1 = new Attendant();
        Attendant attendant2 = new Attendant();
        Attendant attendant3 = new Attendant();
        ParkingLot parkingLot = new ParkingLot(2);

        assertDoesNotThrow(() -> parkingLot.assignAttendant(attendant1));
        assertDoesNotThrow(() -> parkingLot.assignAttendant(attendant2));
        assertDoesNotThrow(() -> parkingLot.assignAttendant(attendant3));
    }

    // Test to check countVehiclesWithColour method when no vehicle is parked
    @Test
    public void testCountVehiclesWithColour_WhenNoVehicleParked_ThenCountIs0() {
        ParkingLot parkingLot = new ParkingLot(2);

        assertEquals(0, parkingLot.countVehiclesWithColour(VehicleColor.WHITE));
    }

    // Test to check countVehiclesWithColour method when no vehicle with white color is parked
    @Test
    public void testCountVehiclesWithColour_WhenNoVehicleWithWhiteColorParked_ThenCountIs0() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(2);
        attendant.assign(parkingLot);

        attendant.park(new Vehicle("KA-01-HH-1234", VehicleColor.BLACK, VehicleType.CAR));
        attendant.park(new Vehicle("KA-01-HH-1235", VehicleColor.BLACK, VehicleType.CAR));

        assertEquals(0, parkingLot.countVehiclesWithColour(VehicleColor.WHITE));
    }

    // Test to check countVehiclesWithColour method when a vehicle with white color is parked
    @Test
    public void testCountVehiclesWithColour_WhenOneVehicleWithWhiteColorParked_ThenCountIs1() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(3);
        attendant.assign(parkingLot);

        attendant.park(new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR));
        attendant.park(new Vehicle("KA-01-HH-1235", VehicleColor.BLACK, VehicleType.CAR));
        attendant.park(new Vehicle("KA-01-HH-1235", VehicleColor.BLUE, VehicleType.CAR));

        assertEquals(1, parkingLot.countVehiclesWithColour(VehicleColor.WHITE));
    }

    // Test to check countVehiclesWithColour method when two vehicles with black color are parked
    @Test
    public void testCountVehiclesWithColour_WhenTwoVehiclesWithBlackColorParked_ThenCountIs2() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(3);
        attendant.assign(parkingLot);

        attendant.park(new Vehicle("KA-01-HH-1234", VehicleColor.BLACK, VehicleType.CAR));
        attendant.park(new Vehicle("KA-01-HH-1235", VehicleColor.BLACK, VehicleType.CAR));
        attendant.park(new Vehicle("KA-01-HH-1235", VehicleColor.BLUE, VehicleType.CAR));

        assertEquals(2, parkingLot.countVehiclesWithColour(VehicleColor.BLACK));
    }

    // Test to check park method when parking lot is full
    @Test
    public void testPark_WhenFullParkingLot_ThrowIllegalStateException() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(1);
        attendant.assign(parkingLot);

        Vehicle vehicle1 = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        attendant.park(vehicle1);

        Vehicle vehicle2 = new Vehicle("KA-01-HH-1235", VehicleColor.BLACK, VehicleType.CAR);
        assertThrows(IllegalStateException.class, () -> attendant.park(vehicle2));
    }

    // Test to check park method when parking lot is empty
    @Test
    public void testPark_WhenEmptyParkingLot_ThenNewTicket() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(2);
        attendant.assign(parkingLot);

        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Ticket ticket = attendant.park(vehicle);

        assertNotNull(ticket);
    }

    // Test to check park method when two empty parking lots
    @Test
    public void testPark_WhenTwoEmptyParkingLots_ThenNewTicket() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot1 = new ParkingLot(2);
        ParkingLot parkingLot2 = new ParkingLot(2);
        attendant.assign(parkingLot1);
        attendant.assign(parkingLot2);

        Vehicle vehicle = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Ticket ticket = attendant.park(vehicle);

        assertNotNull(ticket);
    }

    // Test to check park method when vehicle is parked
    @Test
    public void testUnpark_WhenValidTicket_ThenDoestNotThrowException() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(2);
        attendant.assign(parkingLot);

        Vehicle vehicle1 = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Ticket ticket1 = attendant.park(vehicle1);

        assertDoesNotThrow(() -> parkingLot.unpark(ticket1));
    }

    // Test to check park method when vehicle is un-parked twice
    @Test
    public void testUnpark_WhenInvalidTicket_ThrowIllegalArgumentException() {
        Attendant attendant = new Attendant();
        ParkingLot parkingLot = new ParkingLot(2);
        attendant.assign(parkingLot);

        Vehicle vehicle1 = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Ticket ticket = attendant.park(vehicle1);
        parkingLot.unpark(ticket);

        assertThrows(IllegalArgumentException.class, () -> parkingLot.unpark(ticket));
    }
}
