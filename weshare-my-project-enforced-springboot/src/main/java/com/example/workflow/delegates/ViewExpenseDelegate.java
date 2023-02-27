package com.example.workflow.delegates;

import com.example.workflow.services.ExpenseService;
import com.example.workflow.valueobject.Expense;
import com.example.workflow.valueobject.Person;
import org.apache.commons.validator.routines.EmailValidator;
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
        String initiatorEmail = (String) delegateExecution.getVariable("initiatorEmail");
        EmailValidator validator = EmailValidator.getInstance();
        if (!validator.isValid(initiatorEmail)) {
            throw new IllegalArgumentException("Invalid email address: " + initiatorEmail);
        }

        expenseService.loginUser(initiatorEmail);

        Person loggedinuser = new Person(initiatorEmail);

        List<Expense> receivedExpenses = expenseService.getExpensesToPayFor(loggedinuser);
        System.out.println(receivedExpenses.toString());


    }
}
