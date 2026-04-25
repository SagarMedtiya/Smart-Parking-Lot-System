package com.airtribe.smartparking.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot extends BaseEntity{
    private String name;
    private String address;
    private int totalFloors;
    private List<ParkingFloor> floors;

    public ParkingLot() {
        super();
        this.floors = new ArrayList<>();
    }

    public ParkingLot(String name, String address) {
        this();
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public void setTotalFloors(int totalFloors) {
        this.totalFloors = totalFloors;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
        this.totalFloors = floors.size();
    }

    public void addFloor(ParkingFloor floor) {
        this.floors.add(floor);
        this.totalFloors = this.floors.size();
    }

    public int getTotalAvailableSpots() {
        return floors.stream()
                .mapToInt(ParkingFloor::getAvailableSpotsCount)
                .sum();
    }

    public int getTotalOccupiedSpots() {
        return floors.stream()
                .mapToInt(ParkingFloor::getOccupiedSpotsCount)
                .sum();
    }

    public int getAvailableSpotsByType(VehicleType type) {
        return floors.stream()
                .mapToInt(floor -> floor.getAvailableSpotsByType(type))
                .sum();
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", totalFloors=" + totalFloors +
                ", totalAvailableSpots=" + getTotalAvailableSpots() +
                '}';
    }
}
