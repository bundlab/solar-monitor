package com.solar.repository;

import com.solar.model.SolarReading;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SolarRepository extends JpaRepository<SolarReading, Long> {
    // Returns the latest 10 readings for the dashboard
    List<SolarReading> findTop10ByOrderByTimestampDesc();
}