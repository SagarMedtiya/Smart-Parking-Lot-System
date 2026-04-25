package com.airtribe.smartparking.model;

import java.util.Objects;

public class ParkingSpot extends BaseEntity{
    private String spotNumber;
    private VehicleType spotType;
    private ParkingSpotStatus status;
    private double hourlyRate;
    private ParkingFloor floor;
    private boolean hasElectricCharger;
    private boolean isHandicapAccessible;
    private double width;
    private double length;
    public ParkingSpot(){
        super();
        this.status = ParkingSpotStatus.AVAILABLE;
        this.hasElectricCharger = false;
        this.isHandicapAccessible = false;
    }
    public ParkingSpot(String spotNumber, VehicleType spotType, ParkingFloor floor){
        this();
        this.spotNumber = spotNumber;
        this.spotType = spotType;
        this.floor = floor;
        this.hourlyRate = getDefaultRateByType(spotType);
    }
    public ParkingSpot(String spotNumber, VehicleType spotType, ParkingFloor floor, double hourlyRate){
        this(spotNumber, spotType, floor);
        this.hourlyRate = hourlyRate;
    }
    private double getDefaultRateByType(VehicleType type){
        switch(type){
            case MOTORCYCLE:
                return 1.0;
            case CAR:
                return 3.0;
            case BUS:
                return 8.0;
            default:
                return 2.0;
        }
    }
    public String getSpotNumber() {
        return spotNumber;
    }
    public void setSpotNumber(String spotNumber) {
        this.spotNumber = spotNumber;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public void setSpotType(VehicleType spotType) {
        this.spotType = spotType;
    }

    public ParkingSpotStatus getStatus() {
        return status;
    }
    public void setStatus(ParkingSpotStatus status){
        this.status = status;
        updateTimestamp();
    }
    public double getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public ParkingFloor getFloor(){
        return floor;
    }
    public void setFloor(ParkingFloor floor){
        this.floor = floor;
    }
    public boolean isHasElectricCharger(){
        return hasElectricCharger;
    }
    public void setHasElectricCharger(boolean hasElectricCharger){
        this.hasElectricCharger = hasElectricCharger;
    }
    public boolean isIsHandicapAccessible(){
        return isHandicapAccessible;
    }
    public void setHandicapAccessible(boolean handicapAccessible) {
        isHandicapAccessible = handicapAccessible;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean isOccupied() {
        return status == ParkingSpotStatus.OCCUPIED;
    }

    public void occupy() {
        this.status = ParkingSpotStatus.OCCUPIED;
        updateTimestamp();
    }

    public void release() {
        this.status = ParkingSpotStatus.AVAILABLE;
        updateTimestamp();
    }

    public void reserve() {
        this.status = ParkingSpotStatus.RESERVED;
        updateTimestamp();
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        ParkingSpot that = (ParkingSpot) o;
        return Objects.equals(spotNumber, that.spotNumber) &&
                Objects.equals(floor, that.floor);
    }
    @Override
    public int hashCode(){
        return Objects.hash(spotNumber, floor);
    }
    @Override
    public String toString(){
        return "ParkingSpot{" +
                "spotNumber='" + spotNumber + '\'' +
                ", spotType=" + spotType +
                ", status=" + status +
                ", hourlyRate=" + hourlyRate +
                ", floor=" + (floor != null ? floor.getFloorNumber() : null) +
                '}';
    }
}






















