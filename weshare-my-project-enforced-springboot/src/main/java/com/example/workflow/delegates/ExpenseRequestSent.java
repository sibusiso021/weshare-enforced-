package com.example.workflow.delegates;

import com.example.workflow.services.ExpenseService;
import com.example.workflow.valueobject.Expense;
import com.example.workflow.valueobject.Person;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseRequestSent implements JavaDelegate {

    private final ExpenseService expenseService;
    @Autowired
    public ExpenseRequestSent(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String initiatorEmail = (String) delegateExecution.getVariable("initiatorEmail");
        expenseService.loginUser(initiatorEmail);
        List<Expense> expenseList =  expenseService.getExpensesByEmail(initiatorEmail);
        System.out.println("Alll expenses for" + initiatorEmail + ":");

        for (Expense expense : expenseList){
            System.out.println(expense.toString());
        }
        System.out.println("Expense request sent");
    }
}
