package com.miladro.overridingequalmethodtut;

import lombok.Data;

import java.util.Objects;

@Data
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (! (o instanceof Person))
            return false;
        Person person = (Person) o;
        //Reflexivity AND Symmetricity
        return (this == person) ||
                (person.getFirstName().equals(this.getFirstName())
                && person.getLastName().equals(this.getLastName())
                && person.getAge() == this.getAge());
    }
}
