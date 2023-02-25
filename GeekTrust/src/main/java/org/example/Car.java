package org.example;

import org.example.Exception.VehicleNotAddedException;

public class Car implements Vehicle {

    private Car(String LicencePlate){
        addCarTrip ( LicencePlate );
    }

    public static Vehicle getInstance ( String LicencePlate ) {
        return  new Car (LicencePlate);
    }

    @Override
     public final VehicleType getType ( ) {

        return VehicleType.LightVehicle;
    }

    @Override
    public VehicleName getName ( ) {
        return VehicleName.CAR;
    }


    public void addCarTrip(String LicencePlateNumber){
       try {
           if ( vehicleTrips.containsKey ( LicencePlateNumber ) ) {
               int currentTrips = vehicleTrips.get ( LicencePlateNumber );
               vehicleTrips.put ( LicencePlateNumber , currentTrips + 1 );

           } else {
               vehicleTrips.put ( LicencePlateNumber , 1 );
             }
       }catch ( Exception e ){
           throw new VehicleNotAddedException (  "Car Not added Successfully ");
       }
    }
}
