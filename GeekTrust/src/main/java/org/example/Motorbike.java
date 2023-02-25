package org.example;

import org.example.Exception.VehicleNotAddedException;

public class Motorbike implements Vehicle {

    private Motorbike(String LicencePlate){
        addMotorbikeTrip ( LicencePlate );
    }

    public static Vehicle getInstance ( String LicencePlate ) {
        return new Motorbike ( LicencePlate );
    }

    @Override
    public final VehicleType getType ( ) {

        return VehicleType.TwoWheeler;
    }

    @Override
    public VehicleName getName ( ) {
        return VehicleName.MOTORBIKE;
    }


    public void addMotorbikeTrip(String LicencePlateNumber){
        try {
            if ( vehicleTrips.containsKey ( LicencePlateNumber ) ) {
                int currentTrips = vehicleTrips.get ( LicencePlateNumber );
                vehicleTrips.put ( LicencePlateNumber , currentTrips + 1 );

            } else {
                vehicleTrips.put ( LicencePlateNumber , 1 );
            }
        }catch ( Exception e ){
            throw new VehicleNotAddedException (  "MotorBike Not added Successfully ");
        }
    }
}
