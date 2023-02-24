package com.example.workflow.valueobject;

import org.springframework.stereotype.Component;

@Component
public class Amount {
    private final double amount;

    public Amount(double amount) throws Exception {

        if(amount >= 0){
            throw new Exception("invalid amount");
        }
        this.amount = amount;
    }
}
