package org.example;

import org.example.VehicleName;

import java.util.Objects;

public class VehicleSummary {


   private VehicleName vehicleName;
    private Integer vehicleCount;

    private Integer TollCollected;

    public VehicleSummary (  VehicleName vehicleName , Integer vehicleCount , Integer tollCollected ) {

        this.vehicleName = vehicleName;
        this.vehicleCount = vehicleCount;
        TollCollected = tollCollected;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass ( ) != o.getClass ( ) ) return false;
        VehicleSummary that = (VehicleSummary) o;
        return vehicleName == that.vehicleName;
    }

    @Override
    public int hashCode ( ) {
        return Objects.hash ( vehicleName );
    }

    public VehicleName getVehicleName ( ) {
        return vehicleName;
    }

    public void setVehicleName ( VehicleName vehicleName ) {
        this.vehicleName = vehicleName;
    }

    public Integer getVehicleCount ( ) {
        return vehicleCount;
    }

    public void setVehicleCount ( Integer vehicleCount ) {
        this.vehicleCount = vehicleCount;
    }

    public Integer getTollCollected ( ) {
        return TollCollected;
    }

    public void setTollCollected ( Integer tollCollected ) {
        TollCollected = tollCollected;
    }
}
