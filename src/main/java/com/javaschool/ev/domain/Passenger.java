package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor

public class Passenger {

    private String firstName;
    private String lastName;
    //private Calendar birthDate;


    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public java.lang.String getLastName() {
        return lastName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
