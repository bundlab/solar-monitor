package com.solar.service;

import com.solar.model.SolarReading;
import com.solar.repository.SolarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AutomationService {

    @Autowired
    private SolarRepository repository;

    private final Random random = new Random();

    @Scheduled(fixedRate = 5000)
    public void simulateSolarData() {
        SolarReading reading = new SolarReading();
        
        // Simulate realistic solar panel values
        double voltage = 17.0 + (random.nextDouble() * 3.0); // 17V to 20V
        double current = 1.0 + (random.nextDouble() * 4.0);  // 1A to 5A
        
        reading.setVoltage(voltage);
        reading.setCurrent(current);
        reading.setWattage(voltage * current);
        
        repository.save(reading);
        
        System.out.println(String.format("[AUTO-LOG] Saved Reading: %.2fV | %.2fA | %.2fW", 
                           voltage, current, reading.getWattage()));
    }
}