package com.javaschool.ev.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
@Getter @Setter @NoArgsConstructor

public class Passenger extends AbstractDomain {

    //include passengerID
    //@OneToOne
    //@JoinColumn(name="PassengerID", nullable = false)
    //private passengerID;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="FirstName")
    private String firstName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name="LasttName")
    private String lastName;

    //what format should the birthdate be? Calendar?
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
