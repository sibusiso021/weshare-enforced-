//package com.example.workflow.services;
//
//import com.example.workflow.valueobject.Amount;
//import com.example.workflow.valueobject.Date;
//import com.example.workflow.valueobject.Expense;
//import com.example.workflow.valueobject.Person;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.stereotype.Service;
//@Service
//@Getter
//@Setter
//
//public class PaymentRequestService {
//    private final Expense expense;
//
//    private final Amount amounttopay;
//
//    private final Person personwhoshouldpay;
//
//    private final Date duedate;
//
//
//    public PaymentRequestService(Expense expense, Amount amounttopay, Person personwhoshouldpay, Date duedate) {
//        this.expense = expense;
//        this.amounttopay = amounttopay;
//        this.personwhoshouldpay = personwhoshouldpay;
//        this.duedate=  duedate;
//    }
//
//    private void checkpersonPaying(Person person){
//        if(!this.personwhoshouldpay.equals(person))
//            throw new RuntimeException("wrong person is trying to pay the payment request");
//    }
//
//
//
//
//    public PaymentService pay(Person personwhoshouldpay) {
//        checkpersonPaying(personwhoshouldpay);
//    }
//
//
//
//
//}
