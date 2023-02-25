package org.example;


import org.example.TollCollectionType;
import org.example.Vehicle;
import org.example.Exception.FastagBalnceAlreadyAdded;

import java.util.HashMap;

public class Fastag {
      private static HashMap<String,Integer> fastagWallets=new HashMap<>();

     public static boolean addFastagBalance(String VehicleNumber, Integer Balance){
         fastagWallets.put(VehicleNumber,Balance);
        return true;
     }
     public static boolean isRegistered(String vehicleNumber){
         return fastagWallets.containsKey ( vehicleNumber );
     }

     public static boolean deductFastagBalance(String vehicleNumber,Integer tollCharges , Boolean isDiscount, Vehicle vehicle){
         int currentBalance=fastagWallets.get ( vehicleNumber );
         if(currentBalance>=tollCharges) {
             fastagWallets.put ( vehicleNumber , currentBalance - tollCharges );
             TollCollectionSummary.UpdateTollCollectionSummary ( tollCharges, isDiscount , TollCollectionType.FASTAG , vehicleNumber , vehicle );
             return true;
         }
         return false;
     }

    public static Integer getBalance ( String licencePlate ) {
         return fastagWallets.get ( licencePlate );
    }
}
