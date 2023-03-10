//package com.example.workflow.controller;
//
//import com.example.workflow.services.ExpenseService;
//import com.example.workflow.valueobject.Amount;
//import com.example.workflow.valueobject.Date;
//import com.example.workflow.valueobject.Expense;
//import com.example.workflow.valueobject.Person;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import java.time.LocalDate;
//
//@RestController
//@RequestMapping("/expenses")
//public class ExpenseController {
//
//    private final ExpenseService expenseService;
//
//    public ExpenseController(ExpenseService expenseService) {
//        this.expenseService = expenseService;
//    }
//
//    @PostMapping
//    public void createExpense(
//            @RequestParam String email,
//            @RequestParam String description,
//            @RequestParam double amount,
//            @RequestParam String date) throws Exception {
//
//        // here i Check if user is logged in
//        expenseService.loginUser(email);
//
//        // i was about to create objects for the expense
//        Person person = expenseService.getPerson(email);
//        Amount expenseAmount = new Amount(amount);
//        Date expenseDate = new Date(LocalDate.parse(date));
//
//        // Create the expense and add it to the list
//        Expense expense = new Expense(person, expenseAmount, expenseDate, description, payer);
//        expenseService.getAllExpenses().add(expense);
//    }
//}
