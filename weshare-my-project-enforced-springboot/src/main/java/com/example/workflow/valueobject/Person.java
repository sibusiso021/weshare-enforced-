package com.example.workflow.valueobject;

import lombok.Getter;
import org.apache.commons.validator.routines.EmailValidator;
import org.glassfish.jersey.internal.guava.MoreObjects;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Component
@Getter
public class Person {


    public String getEmail() {
        return email;
    }

    @NotNull
    @NotBlank
    @Email
    private final String email;

    public Person(String email) throws Exception {

        if (!EmailValidator.getInstance().isValid(email)){
            throw new Exception("emaill is not valid");
        }
        this.email = email;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("email", email)
                .toString();
    }
}
