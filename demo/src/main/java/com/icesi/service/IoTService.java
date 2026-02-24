package com.icesi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.icesi.model.Device;
import com.icesi.model.Measurement;
import com.icesi.repository.DeviceRepository;
import com.icesi.repository.MeasurementRepository;

@Service
public class IoTService {
    private Measurement measurement;
    private Device device;
    private final DeviceRepository deviceRepo;
    private final MeasurementRepository measuRepo;

    public IoTService(DeviceRepository deviceRepo, MeasurementRepository measRepo) {
        this.deviceRepo = deviceRepo;
        this.measuRepo = measuRepo;
    }

    public List<Device> getAllDevices() {
        return deviceRepo.findAll();
    }

    public void registerMeasurement(Measurement measurement) {   
        // Valor fuera del rango
        Double valor = measurement.getValor();
        Double maxvalue = device.getMaxValue();
        Double minvalue = device.getMinValue();

        if (valor > maxvalue || valor < minvalue){
            throw new RuntimeException("Valor de la medida fuera del rango del dispositivo");
        }

        // crear
        measuRepo.add(measurement);
    }
}