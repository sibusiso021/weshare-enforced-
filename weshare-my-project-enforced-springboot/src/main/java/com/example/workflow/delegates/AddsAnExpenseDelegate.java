package com.example.workflow.delegates;

import com.example.workflow.services.ExpenseService;
import com.example.workflow.valueobject.Amount;
import com.example.workflow.valueobject.Date;
import com.example.workflow.valueobject.Expense;
import com.example.workflow.valueobject.Person;
import org.apache.commons.validator.routines.EmailValidator;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AddsAnExpenseDelegate implements JavaDelegate {

    private final ExpenseService expenseService;

    @Autowired
    public AddsAnExpenseDelegate(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String initiatorEmail = (String) delegateExecution.getVariable("initiatorEmail");
        String description = (String) delegateExecution.getVariable("description");
        double amount = ((Long) delegateExecution.getVariable("amount")).doubleValue();
        String dateStr = (String) delegateExecution.getVariable("date");
        LocalDate date = LocalDate.parse(dateStr);
        String paidByEmail = (String) delegateExecution.getVariable("paidByEmail");
        delegateExecution.setVariable("payerEmail", paidByEmail);

        EmailValidator validator = EmailValidator.getInstance();
        if (!validator.isValid(initiatorEmail)) {
            throw new IllegalArgumentException("Invalid email address: " + initiatorEmail);
        }

        if (initiatorEmail.equals(paidByEmail)) {
            throw new IllegalArgumentException("The person who added the expense cannot be the one who pays for it.");
        }

        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Cannot add an expense for a past date.");
        }

        expenseService.loginUser(initiatorEmail);

        Person person = new Person(initiatorEmail);
        Person payer = new Person(paidByEmail);
        Amount expenseAmount = new Amount(amount);
        Date expenseDate = new Date(date);

        Expense expense = new Expense(person, expenseAmount, expenseDate, description, payer);
        expenseService.getAllExpenses().add(expense);

        System.out.println(paidByEmail + " has to pay for the expense");

        System.out.println(expenseService.getAllExpenses().toString());

        System.out.println("Expense has been added");
    }
//    <script cam-script type="text/form-script">
//            var email = camForm.variableManager.variableValue('initiatorEmail');
//    var validator = new RegExp('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$');
//
//  if (!validator.test(email)) {
//        throw new Error("Invalid email address: " + email);
//    }
//</script>
}
