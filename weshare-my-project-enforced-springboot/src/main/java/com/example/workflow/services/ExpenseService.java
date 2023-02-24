package com.example.workflow.services;

import com.example.workflow.valueobject.Amount;
import com.example.workflow.valueobject.Date;
import com.example.workflow.valueobject.Expense;
import com.example.workflow.valueobject.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpenseService {

    @Autowired
    private final Person person;
    private final Map<String, Person> loggedInUsers = new HashMap<>();
    private final List<Expense> expenses = new ArrayList<>();

    @Autowired
    public ExpenseService(Person person) {
        this.person = person;
    }

    public void loginUser(String email) throws Exception {
        if (this.person.getEmail() == email) {
            loggedInUsers.put(email, person);


        }


    }
    public List<Expense> getAllExpenses() {
        return expenses;
    }




}
