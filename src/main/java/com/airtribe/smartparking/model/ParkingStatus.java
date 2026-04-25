package com.airtribe.smartparking.model;

public enum ParkingStatus {
    AVAILABLE(1, "Available"),
    OCCUPIED(2, "Occupied"),
    RESERVED(3, "Reserved"),
    MAINTENANCE(4, "Under Maintenance");

    private final int code;
    private final String description;
    ParkingStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }
    public int getCode(){
        return code;
    }
    public String getDescription(){
        return description;
    }
}
