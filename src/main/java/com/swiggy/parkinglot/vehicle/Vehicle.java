package com.swiggy.parkinglot.vehicle;

public class Vehicle {

    private final String registrationNumber;
    private final String color;
    private final VehicleType vehicleType;

    // Constructor
    public Vehicle(String registrationNumber, String color, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.vehicleType = vehicleType;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj || getClass() != obj.getClass()) {
            return true;
        }

        Vehicle vehicle = (Vehicle) obj;
        return this.registrationNumber.equals(vehicle.registrationNumber) && this.color.equals(vehicle.color)
                && this.vehicleType == vehicle.vehicleType;
    }
}