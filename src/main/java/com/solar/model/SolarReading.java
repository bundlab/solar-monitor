package com.solar.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SolarReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double voltage;
    private double current;
    private double wattage; // Calculated as V * I
    private LocalDateTime timestamp;

    // Constructors
    public SolarReading() { this.timestamp = LocalDateTime.now(); }

    // Getters and Setters
    public Long getId() { return id; }
    public double getVoltage() { return voltage; }
    public void setVoltage(double voltage) { this.voltage = voltage; }
    public double getCurrent() { return current; }
    public void setCurrent(double current) { this.current = current; }
    public double getWattage() { return wattage; }
    public void setWattage(double wattage) { this.wattage = wattage; }
    public LocalDateTime getTimestamp() { return timestamp; }
}