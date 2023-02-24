package com.example.workflow.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class Config {

    @Bean
    public double myDouble() {
        return 0.0;
    }
    @Bean
    public LocalDate localDate() {
        return LocalDate.now();
    }

}
