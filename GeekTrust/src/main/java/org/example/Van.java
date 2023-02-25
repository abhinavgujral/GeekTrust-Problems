package org.example;

import org.example.Exception.VehicleNotAddedException;

public class Van implements Vehicle {


    public static final Integer NoTripsPresent = 0;

    private Van(String LicencePlate){
        addVanTrip ( LicencePlate );
    }


    public static Vehicle getInstance ( String LicencePlate ) {
        return new Van ( LicencePlate );
    }

    @Override
    public  final VehicleType getType ( ) {

        return VehicleType.LightVehicle;
    }

    @Override
    public VehicleName getName ( ) {
        return VehicleName.VAN;
    }

    public static Integer  getVanTrips ( String LicencePlateNumber ) {
        if ( vehicleTrips.containsKey ( LicencePlateNumber) )
            return vehicleTrips.get ( LicencePlateNumber );
        return NoTripsPresent;
    }
    public static void addVanTrip(String LicencePlateNumber){
        try {
            if ( vehicleTrips.containsKey ( LicencePlateNumber ) ) {
                int currentTrips = vehicleTrips.get ( LicencePlateNumber );
                vehicleTrips.put ( LicencePlateNumber , currentTrips + 1 );

            } else {
                vehicleTrips.put ( LicencePlateNumber , 1 );
            }
        }catch ( Exception e ){
            throw new VehicleNotAddedException (  "Van Not added Successfully ");
        }
    }
}
