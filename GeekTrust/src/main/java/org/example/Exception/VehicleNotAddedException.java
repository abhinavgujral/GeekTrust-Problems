package org.example.Exception;

public class VehicleNotAddedException extends RuntimeException {
    public VehicleNotAddedException ( String VehicleIsNotAdded ) {
        super(VehicleIsNotAdded);
    }
}
