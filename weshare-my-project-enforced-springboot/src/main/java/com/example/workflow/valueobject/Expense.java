package com.example.workflow.valueobject;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class Expense {
    private final Person person;
    private final Amount amount;
    private final Date date;
    private final String description;
    private Person payer;

    private boolean paid;

    public Expense(Person person, Amount amount, Date date, String description, Person payer) {
        this.person = person;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.payer = payer;
        this.paid = false;
    }

    public Person getPerson() {
        return person;
    }

    public Amount getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Person getPayer() {
        return payer;
    }

    public void setPayer(Person payer) {
        this.payer = payer;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "person=" + person +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", payer=" + payer +
                ", paid=" + paid +
                '}';
    }
}
