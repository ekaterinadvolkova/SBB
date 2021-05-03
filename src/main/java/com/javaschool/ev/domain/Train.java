package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan (basePackages = "com.javaschool.ev")
@Getter  @Setter @NoArgsConstructor
public class Train {

    private int number;
    private int availableSeats;
    private int bookedSeats;
    private String occurence;
    //private Calendar departureTime;

    public Train(int number, int availableSeats, int bookedSeats,
                 String occurence) {
        this.number = number;
        this.availableSeats = availableSeats;
        this.bookedSeats = bookedSeats;
        this.occurence = occurence;
        //this.departureTime = departureTime;
    }

}
