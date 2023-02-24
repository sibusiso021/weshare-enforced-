package com.example.workflow.valueobject;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

@EnableAutoConfiguration
public class Amount {
    private final double amount;

    public Amount(double amount)  {
        this.amount = amount;

    }
}
