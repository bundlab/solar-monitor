package com.solar.controller;

import com.solar.model.SolarReading;
import com.solar.repository.SolarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solar")
public class SolarDataController {

    @Autowired
    private SolarRepository repository;

    // The IoT device calls this endpoint
    @PostMapping("/upload")
    public SolarReading uploadData(@RequestBody SolarReading reading) {
        // Calculate wattage before saving
        reading.setWattage(reading.getVoltage() * reading.getCurrent());
        return repository.save(reading);
    }

    // Your web dashboard calls this to see the latest data
    @GetMapping("/stats")
    public List<SolarReading> getStats() {
        return repository.findTop10ByOrderByTimestampDesc();
    }
}