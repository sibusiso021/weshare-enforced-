package com.example.workflow.delegates;

import com.example.workflow.services.ExpenseService;
import com.example.workflow.valueobject.Person;
import org.apache.commons.validator.routines.EmailValidator;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class ClaimAnExpense implements JavaDelegate {

    private ExpenseService expenseService;
    @Autowired
    public ClaimAnExpense(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String email = (String) delegateExecution.getVariable("email");
        EmailValidator validator = EmailValidator.getInstance();
        if (!validator.isValid(email)) {
            throw new IllegalArgumentException("Invalid email address: " + email);
        }
        expenseService.loginUser(email);

        expenseService.claimExpense(email);
        System.out.println(expenseService.getPerson(email));
        System.out.println("expense claimed");

    }
}
