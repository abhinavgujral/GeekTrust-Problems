package org.example.Exception;

public class VehicleNotRecognised extends RuntimeException {
    public VehicleNotRecognised ( String notAbleToRecogniseVehicle ) {
        super( notAbleToRecogniseVehicle);
    }
}
