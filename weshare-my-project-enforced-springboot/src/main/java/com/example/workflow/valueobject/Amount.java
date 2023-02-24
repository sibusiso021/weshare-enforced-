package com.example.workflow.valueobject;

import org.springframework.stereotype.Component;

@Component
public class Amount {
    private final double amount;

    public Amount(double amount)  {
        this.amount = amount;

    }
}
