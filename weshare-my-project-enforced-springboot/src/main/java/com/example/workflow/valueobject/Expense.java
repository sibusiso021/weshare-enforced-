package com.example.workflow.valueobject;


import org.springframework.stereotype.Component;


@Component
public class Expense {
    public Person getPerson() {
        return person;
    }

    public Amount getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    private final Person person;
    private final Amount amount;
    private final Date date;

    private final String discription;

    public Expense(Person person, Amount amount, Date date, String descriptiom) {
        this.person = person;
        this.amount = amount;
        this.date = date;
        this.discription = descriptiom;
    }


}