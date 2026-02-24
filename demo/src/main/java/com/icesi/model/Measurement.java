package com.icesi.model;

public class Measurement {
    private Integer id;
    private long Timestamp;
    private Double valor;
    private Integer deviceId;

    public Measurement(long Timestamp, Integer deviceId, Integer id, Double valor) {
        this.Timestamp = Timestamp;
        this.deviceId = deviceId;
        this.id = id;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getTimestamp() {
        return Timestamp;
    }

    public void setTimestamp(long Timestamp) {
        this.Timestamp = Timestamp;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getAssetId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
