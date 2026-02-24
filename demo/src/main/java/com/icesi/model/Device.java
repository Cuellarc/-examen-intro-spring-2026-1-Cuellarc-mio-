package com.icesi.model;

public class Device{
    private Integer id;
    private String name;
    private String serialNumber;
    private String type;
    private Double maxValue;
    private Double minValue;
    private long samplingPeriod;
    private long timeTolerance;

    public Device(Integer id, Double maxValue, Double minValue, String name, long samplingPeriod, String serialNumber, long timeTolerance, String type) {
        this.id = id;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.name = name;
        this.samplingPeriod = samplingPeriod;
        this.serialNumber = serialNumber;
        this.timeTolerance = timeTolerance;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public Double getMinValue() {
        return minValue;
    }

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public long getSamplingPeriod() {
        return samplingPeriod;
    }

    public void setSamplingPeriod(long samplingPeriod) {
        this.samplingPeriod = samplingPeriod;
    }

    public long getTimeTolerance() {
        return timeTolerance;
    }

    public void setTimeTolerance(long timeTolerance) {
        this.timeTolerance = timeTolerance;
    }
}