package com.example.workflow.delegates;

import com.example.workflow.services.ExpenseService;
import com.example.workflow.valueobject.Expense;
import com.example.workflow.valueobject.Person;
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

        String email = (String) delegateExecution.getVariable("email");

        expenseService.loginUser(email);

        Person person = new Person(email);
        List<Expense> expensetopay = expenseService.getExpensesToPayFor(person);

        System.out.println(expensetopay);

        if(expensetopay.isEmpty()){
            System.out.println("you have no expense to pay");
        }else{
            System.out.println("These are the expenses you have to pay");
            for(Expense expense: expensetopay){
                System.out.println(expense.toString());
            }
        }





    }
}
