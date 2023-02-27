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
public class ExpenseRquestRecieved implements JavaDelegate {
    private final ExpenseService expenseService;
    @Autowired
    public ExpenseRquestRecieved(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {



        String email = (String) delegateExecution.getVariable("email");
        expenseService.loginUser(email);
        List<Expense> expenseList =  expenseService.getExpensesToPayFor(new Person(email));

        System.out.println("Expenses that you have to pay for0");
        for(Expense expense: expenseList){
            System.out.println(expense.toString());
        }

        System.out.println("expense request recieved delegate class");



    }
}
