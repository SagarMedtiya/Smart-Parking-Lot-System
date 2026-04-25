package com.airtribe.smartparking.model;

import java.util.Date;
import java.util.Objects;

public class ParkingTransaction extends BaseEntity{
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Date entryTime;
    private Date exitTime;
    private TransactionStatus status;
    private double totalFee;
    private String paymentMethod;
    private String paymentReference;
    private String entryGateId;
    private String exitGateId;
    private double discountApplied;
    private String discountCode;

    public ParkingTransaction() {
        super();
        this.status = TransactionStatus.ACTIVE;
        this.entryTime = new Date();
        this.totalFee = 0.0;
        this.discountApplied = 0.0;
    }
    public ParkingTransaction(Vehicle vehicle, ParkingSpot parkingSpot){
        this();
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryGateId = parkingSpot.getFloor().getEntryGateId();
    }
    public ParkingTransaction(Vehicle vehicle, ParkingSpot parkingSpot, String entryGateId){
        this(vehicle, parkingSpot);
        this.entryGateId = entryGateId;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
        updateTimestamp();
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
        updateTimestamp();
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
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

    public double getDiscountApplied() {
        return discountApplied;
    }

    public void setDiscountApplied(double discountApplied) {
        this.discountApplied = discountApplied;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
    public long getParkingDurationInMinutes(){
        if(exitTime == null){
            return 0;
        }
        long diffInMillies = exitTime.getTime() - entryTime.getTime();
        return diffInMillies/( 60 * 1000);
    }
    public long getParkingDurationInHours(){
        long minutes = getParkingDurationInMinutes();
        return (long) Math.ceil(minutes / 60.0);
    }
    public void completeTransaction(double fee, String paymentMethod, String exitGateId) {
        this.totalFee = fee;
        this.paymentMethod = paymentMethod;
        this.exitGateId = exitGateId;
        this.exitTime = new Date();
        this.status = TransactionStatus.COMPLETED;
        updateTimestamp();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingTransaction that = (ParkingTransaction) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ParkingTransaction{" +
                "id='" + id + '\'' +
                ", vehicle=" + (vehicle != null ? vehicle.getLicensePlate() : null) +
                ", spot=" + (parkingSpot != null ? parkingSpot.getSpotNumber() : null) +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", status=" + status +
                ", totalFee=" + totalFee +
                '}';
    }
}














