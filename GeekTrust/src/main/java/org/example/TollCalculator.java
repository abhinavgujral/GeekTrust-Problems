package org.example;

import org.example.Exception.VehicleNotRecognised;

public class TollCalculator {
    public void collectToll( String vehicleType, String LicencePlate){
        Vehicle vehicle= VehicleFactory.getVehicleInstance(vehicleType,LicencePlate);
        if(vehicle.getType ().equals ( VehicleType.HeavyVehicle ))
            collectHeavyVehicelToll(LicencePlate,vehicle);
         else if ( vehicle.getType ().equals ( VehicleType.LightVehicle  ))
            collectLightVehicelToll ( LicencePlate,vehicle );
        else if(vehicle.getType ().equals ( VehicleType.TwoWheeler ))
            collectTwoWheelerToll(LicencePlate,vehicle);
        else
            throw new VehicleNotRecognised ( "vehicle not recognised" );
    }

    private  void collectTwoWheelerToll ( String LicencePlate,Vehicle vehicle ) {
        int collectionAmount=TollCharges.TwoWheeler;
        Boolean isDiscount=Vehicle.getJourneyType (LicencePlate ).equals ( Vehicle.RETURN_JOURNEY );
        Boolean FastagStatus= Fastag.isRegistered ( LicencePlate );
        Integer FastagBalance= Fastag.getBalance(LicencePlate);
        if (isDiscount)
            collectionAmount=TollCharges.TwoWheelerDicounted;
        if(FastagStatus){
            if(FastagBalance< collectionAmount)
                dualModePayment ( FastagBalance,collectionAmount,isDiscount,LicencePlate,vehicle );
            else
                collectViaFastag ( collectionAmount , isDiscount ,  LicencePlate , vehicle );
        }
        else
            collectViaCash ( collectionAmount , isDiscount , LicencePlate , vehicle );
        }

        private  void collectViaFastag(Integer collectionAmt , Boolean isDiscount  , String LicencePlate , Vehicle vehicle){
            Fastag.deductFastagBalance ( LicencePlate , collectionAmt,isDiscount,vehicle );
            TollCollectionSummary.UpdatevehicleSummary ( new VehicleSummary ( vehicle.getName(), Vehicle.vehicleTrips.get(LicencePlate), collectionAmt ) );
        }

private void collectViaCash(Integer collectionAmt , Boolean isDiscount , String LicencePlate , Vehicle vehicle){
    TollCollectionSummary.UpdateTollCollectionSummary ( collectionAmt+TollCharges.CashPaymentFee , isDiscount , TollCollectionType.CASH , LicencePlate , vehicle );
    TollCollectionSummary.UpdatevehicleSummary ( new VehicleSummary ( vehicle.getName(), Vehicle.vehicleTrips.get(LicencePlate), collectionAmt+TollCharges.CashPaymentFee  ) );
}
    private void dualModePayment(Integer FastagBalance, Integer collectionAmt,Boolean isDiscount,String LicencePlate,Vehicle vehicle){
        Fastag.deductFastagBalance ( LicencePlate , FastagBalance,isDiscount,vehicle );
        Integer RemainingCollection=collectionAmt+TollCharges.CashPaymentFee-FastagBalance;
        TollCollectionSummary.UpdateTollCollectionSummary ( RemainingCollection, isDiscount , TollCollectionType.CASH , LicencePlate , vehicle );
        TollCollectionSummary.UpdatevehicleSummary ( new VehicleSummary ( vehicle.getName(), Vehicle.vehicleTrips.get(LicencePlate), collectionAmt+TollCharges.CashPaymentFee  ) );
    }

    private void collectLightVehicelToll ( String LicencePlate,Vehicle vehicle) {
        int collectionAmt=TollCharges.LightVehicle;
        Boolean isDiscount=Vehicle.getJourneyType (LicencePlate ).equals ( Vehicle.RETURN_JOURNEY );
        Boolean FastagStatus= Fastag.isRegistered ( LicencePlate );// && Fastag.checkFastagBalance (LicencePlate, collectionAmt);
        Integer FastagBalance= Fastag.getBalance(LicencePlate);
        if ( isDiscount)
            collectionAmt=TollCharges.LightVehicleDiscounted;
        if(FastagStatus){
            if(FastagBalance< collectionAmt)
                dualModePayment ( FastagBalance,collectionAmt,isDiscount,LicencePlate,vehicle );
                else
                collectViaFastag ( collectionAmt , isDiscount ,  LicencePlate , vehicle );
        }
        else
            collectViaCash ( collectionAmt , isDiscount , LicencePlate , vehicle );

    }


    private void collectHeavyVehicelToll ( String LicencePlate,Vehicle vehicle ) {
        int collectionAmt=TollCharges.HeavyVehicle;
        Boolean isDiscount=Vehicle.getJourneyType (LicencePlate ).equals ( Vehicle.RETURN_JOURNEY );
        Boolean FastagStatus= Fastag.isRegistered ( LicencePlate );// && Fastag.checkFastagBalance (LicencePlate, collectionAmt);
        Integer FastagBalance= Fastag.getBalance(LicencePlate);
        if ( isDiscount)
            collectionAmt=TollCharges.HeavyVehicleDiscounted;
        if(FastagStatus){
            if(FastagBalance< collectionAmt)
                dualModePayment ( FastagBalance,collectionAmt,isDiscount,LicencePlate,vehicle );
            else
                collectViaFastag ( collectionAmt , isDiscount ,  LicencePlate , vehicle );

        }
        else
            collectViaCash ( collectionAmt , isDiscount , LicencePlate , vehicle );
    }
}
