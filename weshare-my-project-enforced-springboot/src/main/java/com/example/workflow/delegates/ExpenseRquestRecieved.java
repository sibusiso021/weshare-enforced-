package com.example.workflow.delegates;

import com.example.workflow.services.ExpenseService;
import com.example.workflow.valueobject.Expense;
import com.example.workflow.valueobject.Person;
import org.apache.commons.validator.routines.EmailValidator;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ExpenseRquestRecieved implements JavaDelegate {
    private final ExpenseService expenseService;
    @Autowired
    public ExpenseRquestRecieved(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String initiatorEmail = (String) delegateExecution.getVariable("initiatorEmail");
        expenseService.loginUser(initiatorEmail);
        Person user = expenseService.getPerson(initiatorEmail);

        List<Expense> expenseToPay =  expenseService.getExpensesToPayFor(user);


        System.out.println(user);

        System.out.println(expenseToPay);

        if(expenseToPay.isEmpty()){
            System.out.println( initiatorEmail + "you have no expense to pay");

        }else {
            System.out.println("These are the expenses you have to pay for: ");
            for(Expense expense : expenseToPay){
                System.out.println(expense.toString());
            }
        }





    }
}
