package com.example.workflow.valueobject;

import lombok.Getter;
import org.springframework.stereotype.Component;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Component
public class Person {
    @Getter
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private final String email;

    public Person(String email) {
        this.email = email;
    }


}
