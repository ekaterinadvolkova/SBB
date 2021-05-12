package com.javaschool.ev.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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

    /*private Passenger(SimpleDateFormat birthDate){
        String pattern = "dd-MM-yyyy";
        birthDate = new SimpleDateFormat(pattern);
    }

    method to transform the BirthDate
    String pattern = "MM-dd-yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    String date = simpleDateFormat.format(new Date());
    System.out.println(date);

    Source:
    https://stackoverflow.com/questions/2923227/displaying-date-of-birth-in-java-by-using-date-util
    */

}
