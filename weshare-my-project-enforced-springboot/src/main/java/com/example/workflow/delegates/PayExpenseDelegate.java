package com.example.workflow.delegates;

import com.example.workflow.services.ExpenseService;
import com.example.workflow.valueobject.Expense;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class PayExpenseDelegate implements JavaDelegate {
    private final ExpenseService expenseService;
    @Autowired
    public PayExpenseDelegate(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String email = (String) delegateExecution.getVariable("email");

        List<Expense> expensetopay = expenseService.getExpensesByEmail(email);
        if(expensetopay.isEmpty()){
            throw new IllegalArgumentException("you have no expense to pay");
        }



        expenseService.deleteExpense((Expense) expensetopay);
        System.out.println("expense deleted");
    }
}
