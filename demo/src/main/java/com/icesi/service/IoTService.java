package com.icesi.service;

import com.icesi.model.Device;
import com.icesi.repository.DeviceRepository;
import com.icesi.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IoTService {

    private final DeviceRepository deviceRepo;
    private final MeasurementRepository measRepo;

    public IoTService(DeviceRepository deviceRepo, MeasurementRepository measRepo) {
        this.deviceRepo = deviceRepo;
        this.measRepo = measRepo;
    }

    public List<Device> getAllDevices() {
        return deviceRepo.findAll();
    }

    public void registerDevice(Device device) {
        if (device.getName() == null || device.getName().trim().isEmpty()) {
            throw new RuntimeException("Nombre inválido (vacío o nulo).");
        }

        if (device.getSerialNumber() == null) {
            throw new RuntimeException("serialNumber no puede ser null.");
        }

        String serial = device.getSerialNumber().trim();


        // a) único
        Device existing = deviceRepo.findBySerialNumber(serial);
        if (existing != null) {
            throw new RuntimeException("Ya existe un dispositivo con ese serialNumber.");
        }

        device.setSerialNumber(serial);



        // crear (no update)
        deviceRepo.add(device);
    }

    public void updateDeviceEstate(long deviceId, String newEstate) {
        if (newEstate == null) throw new RuntimeException("Estado no puede ser null.");
        validateEstate(newEstate);

        Device d = deviceRepo.findById(deviceId);
        if (d == null) throw new RuntimeException("No existe device con id=" + deviceId);

        d.setEstate(newEstate.trim().toUpperCase());
        deviceRepo.update(d);
    }

    public void deleteDevice(long deviceId) {
        // d) no eliminar si tiene mediciones
        if (!measRepo.findByAssetId(deviceId).isEmpty()) {
            throw new RuntimeException("No se puede eliminar: tiene mediciones asociadas.");
        }
        deviceRepo.deleteById(deviceId);
    }

    private void validateEstate(String estate) {
        String e = estate.trim().toUpperCase();
        if (!e.equals("ACTIVE") && !e.equals("INACTIVE")) {
            throw new RuntimeException("Estado inválido. Use ACTIVE o INACTIVE.");
        }
    }
}