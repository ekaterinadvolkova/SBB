package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "passenger")
public class Passenger {


    @Id
    @Column(name = "passengerID")
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passengerID;

    @NonNull
    @Column(name = "firstName")
    private String firstName;

    @NonNull
    @Column(name = "lastName")
    private String lastName;

    //private SimpleDateFormat birthDate;
    @NonNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthDate")
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
