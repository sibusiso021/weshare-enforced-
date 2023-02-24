package com.example.workflow.valueobject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Expense {

    @Autowired
    private final Person person;
    @Autowired
    private final String description;
    @Autowired
    private final Amount amount;
    @Autowired
    private final Date date;




    public Expense(Person person, String description, Amount amount, Date date) {
        this.person = person;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }
}
