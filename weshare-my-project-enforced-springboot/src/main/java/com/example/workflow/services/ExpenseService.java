package com.example.workflow.services;
import com.example.workflow.valueobject.Expense;
import com.example.workflow.valueobject.Person;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

import java.util.List;

@Service
public class ExpenseService {

    private final PersonService personService;
    private final List<Expense> expenses = new ArrayList<>();

    public ExpenseService(PersonService personService) {
        this.personService = personService;
    }

    public void loginUser(String email) throws Exception {
        personService.loginUser(email);
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public Person getPerson(String email) {
        return personService.getPerson(email);
    }
}
