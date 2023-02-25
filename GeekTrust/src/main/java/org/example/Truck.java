package org.example;

import org.example.Exception.VehicleNotAddedException;

public class Truck implements Vehicle {


    public static final Integer NoTripsPresent = 0;

    private Truck( String LicencePlate ){
        addTruckTrip ( LicencePlate );
    }


    public static Vehicle getInstance ( String LicencePlate ) {
        return new Truck ( LicencePlate );
    }

    @Override
    public  final VehicleType getType ( ) {

        return VehicleType.HeavyVehicle;
    }

    @Override
    public VehicleName getName ( ) {
        return VehicleName.TRUCK;
    }

    public static Integer  getTruckTrips ( String LicencePlateNumber ) {
        if ( vehicleTrips.containsKey ( LicencePlateNumber) )
            return vehicleTrips.get ( LicencePlateNumber );
        return NoTripsPresent;
    }
    public static void addTruckTrip(String LicencePlateNumber){
        try {
            if ( vehicleTrips.containsKey ( LicencePlateNumber ) ) {
                int currentTrips = vehicleTrips.get ( LicencePlateNumber );
                vehicleTrips.put ( LicencePlateNumber , currentTrips + 1 );

            } else {
                vehicleTrips.put ( LicencePlateNumber , 1 );
            }
        }catch ( Exception e ){
            throw new VehicleNotAddedException (  "Truck Not added Successfully ");
        }
    }
}
