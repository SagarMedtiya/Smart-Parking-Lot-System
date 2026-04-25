package com.airtribe.smartparking.model;


public enum VehicleType {
    MOTORCYCLE(1, "Motorcycle"),
    CAR(2, "Car"),
    BUS(3, "Bus");

    private final int code;
    private final String description;

    VehicleType(int code, String description) {
        this.code = code;
        this.description = description;
    }
    public int getCode() {
        return code;
    }
    public String getDescription() {
        return description;
    }
    public static VehicleType fromCode(int code) {
        for(VehicleType type: values()){
            if(type.code == code){
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid vehicle type code: "+ code);
    }
}























