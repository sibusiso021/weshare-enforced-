package com.example.workflow.valueobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@EnableAutoConfiguration
public class Date {
    private final LocalDate date;

    @Autowired
    public Date(LocalDate date) {
        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Cannot add an expense for a past date.");
        }
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
