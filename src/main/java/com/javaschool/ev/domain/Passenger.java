package com.javaschool.ev.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="passenger")
public class Passenger {


    @Id
    @Column(name="passengerID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passengerID;

    @Column(name="firstName")
    private String firstName;

    @Column(name="lastName")
    private String lastName;

    //private SimpleDateFormat birthDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="birthDate")
    private LocalDate birthDate;

    public Passenger(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Passenger " + firstName + " " + lastName + " " + birthDate;
    }


}
