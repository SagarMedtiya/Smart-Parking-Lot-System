package com.airtribe.smartparking.model;

import java.util.ArrayList;
import java.util.Objects;

public class ParkingFloor extends BaseEntity{
    private int floorNumber;
    private String floorName;
    private int totalSpots;
    private boolean isAccessible;
    private boolean hasElectricCharging;
    private String entryGateId;
    private String exitGateId;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(){
        super();
        this.parkingSpots = new ArrayList<>();
        this.isAccessible = true;
        this.hasElectricCharging = false;
    }
    public ParkingFloor(int floorNumber, String floorName, int totalSpots){
        this();
        this.floorNumber = floorNumber;
        this.floorName = floorName;
        this.totalSpots = totalSpots;
    }
    public int getFloorNumber(){
        return floorNumber;
    }
    public void setFloorNumber(int floorNumber){
        this.floorNumber = floorNumber;
    }
    public String getFloorName(){
        return floorName;
    }
    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public int getTotalSpots() {
        return totalSpots;
    }

    public void setTotalSpots(int totalSpots) {
        this.totalSpots = totalSpots;
    }

    public boolean isAccessible() {
        return isAccessible;
    }

    public void setAccessible(boolean accessible) {
        isAccessible = accessible;
    }

    public boolean isHasElectricCharging() {
        return hasElectricCharging;
    }

    public void setHasElectricCharging(boolean hasElectricCharging) {
        this.hasElectricCharging = hasElectricCharging;
    }

    public String getEntryGateId() {
        return entryGateId;
    }

    public void setEntryGateId(String entryGateId) {
        this.entryGateId = entryGateId;
    }

    public String getExitGateId() {
        return exitGateId;
    }

    public void setExitGateId(String exitGateId) {
        this.exitGateId = exitGateId;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public void addParkingSpot(ParkingSpot spot){
        spot.setFloor(this);
        this.parkingSpots.add(spot);
    }
    public int getOccupiedSpotsCount(){
        return (int) parkingSpots.stream()
                .filter(spot -> spot.getStatus() == ParkingSpotStatus.OCCUPIED)
                .count();
    }
    public int getAvailableSpotsCount(){
        return (int) parkingSpots.stream()
                .filter(spot -> spot.getStatus() == ParkingSpotStatus.AVAILABLE)
                .count();
    }
    public int getAvailableSpotsByType(VehicleType type){
        return (int) parkingSpots.stream()
                .filter(spot ->spot.getStatus() == ParkingSpotStatus.AVAILABLE)
                .filter(spot -> spot.getSpotType() == type)
                .count();
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        ParkingFloor that = (ParkingFloor) o;
        return floorNumber == that.floorNumber && Objects.equals(id, that.id);
    }
    @Override
    public String toString(){
        return "ParkingFloor{"+
                "floorNumber=" + floorNumber +
                ", floorName='" + floorName + '\'' +
                ", totalSpots=" + totalSpots +
                ", occupiedSpots=" + getOccupiedSpotsCount() +
                '}';
    }

}




























