package com.example.workflow.delegates;


import com.example.workflow.services.ExpenseService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



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
        expenseService.payExpenseByEmail(email);
        System.out.println("Expense paid for user" + email);


    }
}
