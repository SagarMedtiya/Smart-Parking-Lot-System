package com.airtribe.smartparking.model;

import java.util.Objects;

public class Vehicle extends BaseEntity{
    private String licensePlate;
    private VehicleType vehicleType;
    private String ownerName;
    private String ownerPhone;
    private String ownerEmail;
    private String vehicleColor;
    private String vehicleModel;
    public Vehicle(){
        super();
    }
    public Vehicle(String licensePlate, VehicleType vehicleType){
        this();
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }
    public Vehicle(String licensePlate,VehicleType vehicleType, String ownerName, String ownerPhone){
        this(licensePlate, vehicleType);
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
    }
    public String getLicensePlate() {
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(licensePlate, vehicle.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "licensePlate='" + licensePlate + '\'' +
                ", vehicleType=" + vehicleType +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }

}









