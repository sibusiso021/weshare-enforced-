package com.example.workflow.services;

import com.example.workflow.valueobject.Expense;
import com.example.workflow.valueobject.Person;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Scope("singleton")
public class ExpenseService {

    private final PersonService personService;
    private final List<Expense> expenses = new ArrayList<>();

    public ExpenseService(PersonService personService) {
        this.personService = personService;
    }

    public void loginUser(String email) throws Exception {
        personService.loginUser(email);
    }

    public List<Expense> getExpensesByEmail(String email){
        return getAllExpenses().stream().filter(expense -> expense.getPerson().getEmail().equals(email)).collect(Collectors.toList());
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public Person getPerson(String email) {
        return personService.getPerson(email);
    }

    public void claimExpense(String email){
        payExpenseByEmail(email);
    }

    public void payExpenseByEmail(String email){
        for(Expense expense : expenses){
            if(expense.getPerson().getEmail().equals(email)){
                expense.setPaid(true);
                break;
            }
        }
    }

    public List<Expense> getExpensesToPayFor(Person user) {
        List<Expense> expensesToPayFor = new ArrayList<>();

        for (Expense expense : expenses) {
            if (expense.getPayer().equals(user) && !expense.getPerson().equals(user)) {
                expensesToPayFor.add(expense);
            }
        }

        return expensesToPayFor;
    }

    public List<Expense> getExpensesToPayFor(String email) {
        Person user = personService.getPerson(email);
        if (user == null) {
            return new ArrayList<>();
        }

        return getExpensesToPayFor(user);
    }
}
