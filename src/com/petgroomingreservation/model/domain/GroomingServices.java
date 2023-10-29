package com.petgroomingreservation.model.domain;

import java.util.Objects;

/*
  GroomingServices domain to service related items
 */
public class GroomingServices {
    private String serviceName;
    private Integer minutes;

    //no args constuctor
    public GroomingServices(){
    }

    //all parameters constuctor
    public GroomingServices(String serviceName, Integer minutes) {
        this.serviceName = serviceName;
        this.minutes = minutes;
    }

    //getters and setters

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    //toString method - can be used for logging
    @Override
    public String toString() {
        return "GroomingServices{" +
                "serviceName='" + serviceName + '\'' +
                ", minutes=" + minutes +
                '}';
    }

    //equals method to validate objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroomingServices that)) return false;
        return Objects.equals(serviceName, that.serviceName) && Objects.equals(minutes, that.minutes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName, minutes);
    }
}
