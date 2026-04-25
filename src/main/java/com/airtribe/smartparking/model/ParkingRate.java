package com.airtribe.smartparking.model;

import java.util.Date;
import java.util.Objects;

public class ParkingRate extends BaseEntity{
    private VehicleType vehicleType;
    private double firstHourRate;
    private double subsequentHourRate;
    private double dailyMaxRate;
    private double weeklyMaxRate;
    private double monthlyMaxRate;
    private int gracePeriodMinutes;
    private Date effectiveFrom;
    private Date effectiveTo;
    private boolean isActive;

    public ParkingRate(){
        super();
        this.gracePeriodMinutes = 15;
        this.isActive = true;
        this.effectiveFrom = new Date();

    }
    public ParkingRate(VehicleType vehicleType, double firstHourRate, double subsequentHourRate, double dailyMaxRate){
        this();
        this.vehicleType = vehicleType;
        this.firstHourRate = firstHourRate;
        this.subsequentHourRate = subsequentHourRate;
        this.dailyMaxRate = dailyMaxRate;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getFirstHourRate() {
        return firstHourRate;
    }

    public void setFirstHourRate(double firstHourRate) {
        this.firstHourRate = firstHourRate;
    }

    public double getSubsequentHourRate() {
        return subsequentHourRate;
    }

    public void setSubsequentHourRate(double subsequentHourRate) {
        this.subsequentHourRate = subsequentHourRate;
    }

    public double getDailyMaxRate() {
        return dailyMaxRate;
    }

    public void setDailyMaxRate(double dailyMaxRate) {
        this.dailyMaxRate = dailyMaxRate;
    }

    public double getWeeklyMaxRate() {
        return weeklyMaxRate;
    }

    public void setWeeklyMaxRate(double weeklyMaxRate) {
        this.weeklyMaxRate = weeklyMaxRate;
    }

    public double getMonthlyMaxRate() {
        return monthlyMaxRate;
    }

    public void setMonthlyMaxRate(double monthlyMaxRate) {
        this.monthlyMaxRate = monthlyMaxRate;
    }

    public int getGracePeriodMinutes() {
        return gracePeriodMinutes;
    }

    public void setGracePeriodMinutes(int gracePeriodMinutes) {
        this.gracePeriodMinutes = gracePeriodMinutes;
    }

    public Date getEffectiveFrom() {
        return effectiveFrom;
    }

    public void setEffectiveFrom(Date effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public Date getEffectiveTo() {
        return effectiveTo;
    }

    public void setEffectiveTo(Date effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    public boolean isValidForDate(Date date){
        if(effectiveFrom != null && date.before(effectiveFrom)){
            return false;
        }
        if(effectiveTo != null && date.after(effectiveTo)){
            return false;
        }
        return isActive;
    }
    public double calculateFee(long durationHours){
        if(durationHours <= 0){
            return 0.0;
        }
        double fee = firstHourRate;
        if (durationHours > 1) {
            fee += subsequentHourRate * (durationHours - 1);
        }

        return Math.min(fee, dailyMaxRate);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingRate that = (ParkingRate) o;
        return vehicleType == that.vehicleType &&
                Objects.equals(effectiveFrom, that.effectiveFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleType, effectiveFrom);
    }

    @Override
    public String toString() {
        return "ParkingRate{" +
                "vehicleType=" + vehicleType +
                ", firstHourRate=" + firstHourRate +
                ", subsequentHourRate=" + subsequentHourRate +
                ", dailyMaxRate=" + dailyMaxRate +
                '}';
    }
}


















