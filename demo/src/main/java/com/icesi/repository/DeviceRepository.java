package com.icesi.repository;

import com.icesi.model.Device;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeviceRepository {

    private final List<Device> devices = new ArrayList<>();
    private Integer currentId;

    public DeviceRepository() {
        add(new Device(""));
        add(new Device(""));
    }

    public void add(Device device) {
        currentId++;
        device.setId(currentId);
        devices.add(device);
    }

    public void update(Device device) {
        for (int i = 0; i < devices.size(); i++) {
            if (devices.get(i).getId().equals(device.getId())) {
                devices.set(i, device);
                return;
            }
        }
    }

    public List<Device> findAll() {
        return devices;
    }

    public Device findById(long id) {
        return devices.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Device findBySerialNumber(String serialNumber) {
        return devices.stream()
                .filter(d -> d.getSerialNumber().equals(serialNumber))
                .findFirst()
                .orElse(null);
    }

    public void deleteById(Integer id) {
        devices.removeIf(d -> d.getId().equals(id));
    }
}