package org.example;
import org.example.Exception.VehicleNotRecognised;

public class VehicleFactory {


public static Vehicle getVehicleInstance( String vehicleName, String LicencePlate){
    if(vehicleName.equals ( "CAR" ))
        return Car.getInstance (LicencePlate);
    else if ( vehicleName.equals ( "VAN" ) )
        return Van.getInstance ( LicencePlate );

        else if(vehicleName.equals ( "RICKSHAW" ))
        return Rickshaw.getInstance ( LicencePlate );
            else if(vehicleName.equals ( "TRUCK" ))
        return Truck.getInstance ( LicencePlate );
                else if(vehicleName.equals ( "BUS" ))
        return Bus.getInstance ( LicencePlate );
                    else if(vehicleName.equals ( "MOTORBIKE" ))
        return Motorbike.getInstance ( LicencePlate );
                        else if(vehicleName.equals ( "SCOOTER" ))
        return Scooter.getInstance ( LicencePlate );
                        else
                            throw new VehicleNotRecognised (   "not able to recognise Vehicle");


}

}
