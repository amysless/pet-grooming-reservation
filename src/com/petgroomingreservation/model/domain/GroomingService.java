package com.petgroomingreservation.model.domain;

import java.util.Objects;

/*
  GroomingServices domain to service related items
 */
public class GroomingService {

    private Integer serviceId;

    private String serviceName;
    private Integer minutes;

    //no args constuctor
    public GroomingService() {
    }

    //all parameters constuctor
    public GroomingService(Integer serviceId, String serviceName, Integer minutes) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.minutes = minutes;
    }

    //getters and setters

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

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
                "serviceId='" + serviceId + '\'' +
                "serviceName='" + serviceName + '\'' +
                ", minutes=" + minutes +
                '}';
    }

    //equals method to validate objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroomingService that)) return false;
        return Objects.equals(serviceId, that.serviceId) && Objects.equals(serviceName, that.serviceName) && Objects.equals(minutes, that.minutes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceId, serviceName, minutes);
    }
}
