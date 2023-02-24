package com.example.workflow.delegates;

import com.example.workflow.services.ExpenseService;
import com.example.workflow.valueobject.Expense;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewExpenseDelegate implements JavaDelegate {

    private final ExpenseService expenseService;

    @Autowired
    public ViewExpenseDelegate(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String email = (String) delegateExecution.getVariable("email");
        List<Expense> expenses = expenseService.getExpensesByEmail(email);
        System.out.println("Expenses for user " + email + ":");
        for (Expense expense : expenses) {
            System.out.println(expense.toString());
        }
        System.out.println("process is finished");
    }
}
