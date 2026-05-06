package com.solar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  // This line is key for automatic tasks
public class SolarMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(SolarMonitorApplication.class, args);
    }
}