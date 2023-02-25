package org.example;

import org.example.Exception.VehicleNotAddedException;

public class Bus implements Vehicle {


    private Bus(String LicencePlate){
        addBusTrip ( LicencePlate );
    }


    public static Vehicle getInstance ( String LicencePlate ) {

        return new Bus(LicencePlate);
    }

    @Override
     public final VehicleType getType ( ) {

        return VehicleType.HeavyVehicle;
    }

    @Override
    public final VehicleName getName ( ) {
        return VehicleName.BUS;
    }



    public void addBusTrip(String LicencePlateNumber){
       try {
           if ( vehicleTrips.containsKey ( LicencePlateNumber ) ) {
               int currentTrips = vehicleTrips.get ( LicencePlateNumber );
               vehicleTrips.put ( LicencePlateNumber , currentTrips + 1 );

           } else {
               vehicleTrips.put ( LicencePlateNumber , 1 );
             }
       }catch ( Exception e ){
           throw new VehicleNotAddedException (  "Bus Not added Successfully ");
       }
    }
}
