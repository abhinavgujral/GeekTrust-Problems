package org.example;

import java.util.HashMap;


public interface Vehicle {

      HashMap <String,Integer> vehicleTrips=new HashMap<> ();
      String RETURN_JOURNEY = "return";
      String ONE_WAY="Oneway";

      VehicleType getType();
      VehicleName getName ( );

     static String getJourneyType (String LincencePlateNumber ){
         if(vehicleTrips.containsKey ( LincencePlateNumber) )
             if(vehicleTrips.get(LincencePlateNumber)>0 && vehicleTrips.get ( LincencePlateNumber )%2==0)
                 return RETURN_JOURNEY;

         return ONE_WAY;
     }


}
