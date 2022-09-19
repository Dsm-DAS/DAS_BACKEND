package com.das.das_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class DasBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DasBackendApplication.class, args);
    }

}
