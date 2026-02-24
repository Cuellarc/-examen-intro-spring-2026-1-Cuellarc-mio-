package com.icesi.repository;

import com.icesi.model.Device;
import com.icesi.model.Measurement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MeasurementRepository {

    private final List<Measurement> measurements = new ArrayList<>();
    private Integer currentId;

    public MeasurementRepository() {
        save(new Measurement(""));
        save(new Measurement(""));
    }

    public void save(Measurement m) {
        currentId++;
        m.setId(currentId);
        measurements.add(m);
    }
    public void add(Measurement measurement) {
        currentId++;
        measurement.setId(currentId);
        measurement.add(measurement);
    }

}