package com.example.workflow.services;

import com.example.workflow.valueobject.Person;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonService {

    private final Map<String, Person> loggedInUsers = new HashMap<>();

    public void loginUser(String email) throws Exception {
        Person person = new Person(email);
        loggedInUsers.put(email, person);
    }

    public Person getPerson(String email) {
        return loggedInUsers.get(email);
    }
}
