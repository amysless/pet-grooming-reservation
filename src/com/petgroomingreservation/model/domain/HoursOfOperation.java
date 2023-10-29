package com.petgroomingreservation.model.domain;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Objects;

/*
  HoursOfOperation domain to denote hours of operation
 */
public class HoursOfOperation {
    private LocalTime openTime;

    private LocalTime closeTime;

    private DayOfWeek dayOfWeek;

    //no args constructor
    public HoursOfOperation(){
    }

    //all args constructor
    public HoursOfOperation(LocalTime openTime, LocalTime closeTime, DayOfWeek dayOfWeek) {
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.dayOfWeek = dayOfWeek;
    }

    //getters and setters
    public LocalTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalTime openTime) {
        this.openTime = openTime;
    }

    public LocalTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalTime closeTime) {
        this.closeTime = closeTime;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    //toString method
    @Override
    public String toString() {
        return "HoursOfOperation{" +
                "openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", dayOfWeek=" + dayOfWeek +
                '}';
    }

    //equals method to validate objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HoursOfOperation that)) return false;
        return Objects.equals(openTime, that.openTime) && Objects.equals(closeTime, that.closeTime) && dayOfWeek == that.dayOfWeek;
    }

    @Override
    public int hashCode() {
        return Objects.hash(openTime, closeTime, dayOfWeek);
    }
}
