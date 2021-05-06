package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
public class Passenger {


    private int passengerID;
    private String firstName;
    private String lastName;
    //private SimpleDateFormat birthDate;
    private String birthDate;


    public Passenger(String firstName, String lastName, String birthDate) {
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
