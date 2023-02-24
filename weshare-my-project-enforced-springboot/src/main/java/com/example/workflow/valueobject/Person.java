package com.example.workflow.valueobject;

import lombok.Getter;
import org.apache.commons.validator.routines.EmailValidator;
import org.glassfish.jersey.internal.guava.MoreObjects;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;


public class Person {

    @Getter
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private final String email;

    public Person(String email) {
        this.email = email;
    }

    // getter and setter methods
}
