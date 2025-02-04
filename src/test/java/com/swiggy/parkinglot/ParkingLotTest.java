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

    // Test to check countVehiclesWithColour method when no vehicle is parked
    @Test
    public void testCountVehiclesWithColour_WhenNoVehicleParked_ThenCountIs0() {
        ParkingLot parkingLot = new ParkingLot(2);

        assertEquals(0, parkingLot.countVehiclesWithColour(VehicleColor.WHITE));
    }

    // Test to check countVehiclesWithColour method when no vehicle with white color is parked
    @Test
    public void testCountVehiclesWithColour_WhenNoVehicleWithWhiteColorParked_ThenCountIs0() {
        ParkingLotAttendant attendant = new ParkingLotAttendant();
        ParkingLot parkingLot = new ParkingLot(2);
        attendant.assign(parkingLot);

        attendant.park(new Vehicle("KA-01-HH-1234", VehicleColor.BLACK, VehicleType.CAR));
        attendant.park(new Vehicle("KA-01-HH-1235", VehicleColor.BLACK, VehicleType.CAR));

        assertEquals(0, parkingLot.countVehiclesWithColour(VehicleColor.WHITE));
    }

    // Test to check countVehiclesWithColour method when a vehicle with white color is parked
    @Test
    public void testCountVehiclesWithColour_WhenOneVehicleWithWhiteColorParked_ThenCountIs1() {
        ParkingLotAttendant attendant = new ParkingLotAttendant();
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
        ParkingLotAttendant attendant = new ParkingLotAttendant();
        ParkingLot parkingLot = new ParkingLot(3);
        attendant.assign(parkingLot);

        attendant.park(new Vehicle("KA-01-HH-1234", VehicleColor.BLACK, VehicleType.CAR));
        attendant.park(new Vehicle("KA-01-HH-1235", VehicleColor.BLACK, VehicleType.CAR));
        attendant.park(new Vehicle("KA-01-HH-1235", VehicleColor.BLUE, VehicleType.CAR));

        assertEquals(2, parkingLot.countVehiclesWithColour(VehicleColor.BLACK));
    }

    // Test to check park method when vehicle is parked
    @Test
    public void testUnpark_WhenValidTicket_ThenDoestNotThrowException() {
        ParkingLotAttendant attendant = new ParkingLotAttendant();
        ParkingLot parkingLot = new ParkingLot(2);
        attendant.assign(parkingLot);

        Vehicle vehicle1 = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Ticket ticket1 = attendant.park(vehicle1);

        assertDoesNotThrow(() -> parkingLot.unpark(ticket1));
    }

    // Test to check park method when vehicle is un-parked twice
    @Test
    public void testUnpark_WhenInvalidTicket_ThrowIllegalArgumentException() {
        ParkingLotAttendant attendant = new ParkingLotAttendant();
        ParkingLot parkingLot = new ParkingLot(2);
        attendant.assign(parkingLot);

        Vehicle vehicle1 = new Vehicle("KA-01-HH-1234", VehicleColor.WHITE, VehicleType.CAR);
        Ticket ticket = attendant.park(vehicle1);
        parkingLot.unpark(ticket);

        assertThrows(IllegalArgumentException.class, () -> parkingLot.unpark(ticket));
    }
}
