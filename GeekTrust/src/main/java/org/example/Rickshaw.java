package org.example;

import org.example.Exception.VehicleNotAddedException;

public class Rickshaw implements Vehicle {



    private Rickshaw(String LicencePlate){
        addRickshawTrip ( LicencePlate );
    }

    public static Vehicle getInstance ( String LicencePlate ) {
        return new Rickshaw ( LicencePlate );
    }

    @Override
    public final VehicleType getType ( ) {
        return VehicleType.LightVehicle;
    }

    @Override
    public final VehicleName getName ( ) {
        return VehicleName.RICKSHAW;
    }


    public void addRickshawTrip(String LicencePlateNumber){
        try {
            if ( vehicleTrips.containsKey ( LicencePlateNumber ) ) {
                int currentTrips = vehicleTrips.get ( LicencePlateNumber );
                vehicleTrips.put ( LicencePlateNumber , currentTrips + 1 );

            } else {
                vehicleTrips.put ( LicencePlateNumber , 1 );
            }
        }catch ( Exception e ){
            throw new VehicleNotAddedException (  "Rickshaw Not added Successfully ");
        }
    }
}
