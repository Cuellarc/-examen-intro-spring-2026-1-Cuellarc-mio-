package com.icesi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.icesi.model.Device;

@Component
public class DeviceRepository {

    private final List<Device> devices = new ArrayList<>();
    private Integer currentId;

    public DeviceRepository() {
        add(new Device(null, 1500.0, 1000.0, "Temp Sensor 1", 2000, "1234F", 10, "Sensor de temperatura"));
    }

    public void add(Device device) {
        currentId++;
        device.setId(currentId);
        devices.add(device);
    }
}