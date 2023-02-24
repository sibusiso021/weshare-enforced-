package com.example.workflow.valueobject;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Date {

    private final LocalDate localDate;

    public Date(LocalDate localDate) {
        this.localDate = localDate;
    }
}
