package com.example.workflow.delegates;

import com.example.workflow.services.ExpenseService;
import com.example.workflow.valueobject.Amount;
import com.example.workflow.valueobject.Date;
import com.example.workflow.valueobject.Expense;
import com.example.workflow.valueobject.Person;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AddanExpenseDelegate implements JavaDelegate {

    private final ExpenseService expenseService;

    @Autowired
    public AddanExpenseDelegate(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String email = (String) delegateExecution.getVariable("email");
        String description = (String) delegateExecution.getVariable("description");
        double amount = Double.parseDouble((String) delegateExecution.getVariable("amount"));
        String dateStr = (String) delegateExecution.getVariable("date");
        LocalDate date = LocalDate.parse(dateStr);

        expenseService.loginUser(email);

        Person person = new Person(email);
        Amount expenseAmount = new Amount(amount);
        Date expenseDate = new Date(date);

        Expense expense = new Expense(person, description, expenseAmount, expenseDate);
        expenseService.getAllExpenses().add(expense);
    }
}
