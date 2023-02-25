package org.example;

import org.example.TollCollectionType;
import org.example.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TollCollectionSummary {
    private static Integer TotalCollection = 0;
    private static Integer TotalDiscountGiven=0;

    private static Integer TollCollectedViaFastag=0;
    private static Integer TollCollectedViaCash=0;
    private static Integer TotalFlatfeeforCash=0;


    private static List < VehicleSummary > vehicleSummaryList = new ArrayList <> ( );

    public static void UpdatevehicleSummary ( VehicleSummary vehicleSummary ) {

         if(vehicleSummaryList.contains ( vehicleSummary )) {
            vehicleSummaryList.stream ( ).map ( p -> {
           if ( p.getVehicleName ( ).equals ( vehicleSummary.getVehicleName ( ) ) ) {
            p.setTollCollected ( p.getTollCollected ( ) + vehicleSummary.getTollCollected ( ) );
            p.setVehicleCount ( p.getVehicleCount ( ) + 1 );
        }
        return p;
    } ).collect( Collectors.toList());
}
else
    vehicleSummaryList.add(vehicleSummary);

    }

    public static void UpdateTollCollectionSummary( Integer TollCollected, Boolean DiscountGiven, TollCollectionType tollCollectionType, String LicencePlate, Vehicle vehicle ){


        if(tollCollectionType.equals ( TollCollectionType.FASTAG ))
        TollCollectedViaFastag +=TollCollected;
        else if ( tollCollectionType.equals ( TollCollectionType.CASH ) ) {
            TollCollectedViaCash +=(TollCollected-TollCharges.CashPaymentFee);
            TotalFlatfeeforCash+=TollCharges.CashPaymentFee;
        }
        if(DiscountGiven && tollCollectionType.equals ( TollCollectionType.FASTAG ))
            TotalDiscountGiven+=TollCollected;
        if(DiscountGiven && tollCollectionType.equals ( TollCollectionType.CASH ) )
            TotalDiscountGiven+=TollCollected-TollCharges.CashPaymentFee;
    }

    public static void printCollection ( ) {
        TollCollectionSummary.sortVehicleList();
        System.out.println("TOTAL_COLLECTION "+TollCollectionSummary.getTotalTollCollection()+" "+TotalDiscountGiven);
        int TotalCashAmt=TollCollectedViaCash +TotalFlatfeeforCash;
        System.out.println ("PAYMENT_SUMMARY "+TollCollectedViaFastag+" "+ TotalCashAmt);
        System.out.println ("VEHICLE_TYPE_SUMMARY" );
        vehicleSummaryList.stream().forEach (p-> System.out.println (p.getVehicleName ().toString ()+" "+p.getVehicleCount () )  );

    }


    public static void sortVehicleList ( ) {
        vehicleSummaryList.sort ( Comparator.comparing ( VehicleSummary::getTollCollected ).reversed ()
                .thenComparing ( VehicleSummary::getVehicleName ) );
    }

    public  static Integer  getTotalTollCollection ( ) {
         TotalCollection +=TotalFlatfeeforCash+ TollCollectedViaCash + TollCollectedViaFastag;
         return TotalCollection;
    }


    }

