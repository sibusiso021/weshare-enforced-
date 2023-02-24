package com.example.workflow.valueobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Date {
    private final LocalDate date;

    @Autowired
    public Date(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
