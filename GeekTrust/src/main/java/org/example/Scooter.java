package org.example;

import org.example.Exception.VehicleNotAddedException;

import java.util.HashMap;

public class Scooter implements Vehicle {

    private Scooter(String LicencePlate){
        addScooterTrip ( LicencePlate );
    }


    public static Vehicle getInstance ( String LicencePlate ) {
        return new Scooter ( LicencePlate );
    }

    @Override
    public final VehicleType getType ( ) {

        return VehicleType.TwoWheeler;
    }

    @Override
    public final VehicleName getName ( ) {
        return VehicleName.SCOOTER;
    }


    public void addScooterTrip(String LicencePlateNumber){
        try {
            if ( Vehicle.vehicleTrips.containsKey ( LicencePlateNumber ) ) {
                int currentTrips = Vehicle.vehicleTrips.get ( LicencePlateNumber );
                Vehicle.vehicleTrips.put ( LicencePlateNumber , currentTrips + 1 );

            } else {
                Vehicle.vehicleTrips.put ( LicencePlateNumber , 1 );
            }
        }catch ( Exception e ){
            throw new VehicleNotAddedException (  "Scooter Not added Successfully ");
        }
    }
}
