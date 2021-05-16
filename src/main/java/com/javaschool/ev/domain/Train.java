package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="train")
public class Train {

    @Id
    @Column(name="trainID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainID;

    @NonNull
    @Column(name="number")
    private int number;

    @NonNull
    @Column(name="availableSeats")
    private int availableSeats;

    @NonNull
    @Column(name="occurence")
    private String occurence;

    //add first Date to the class to generate timetable
    LocalDate firstDate = LocalDate.now();

    //add last date for the timetable
    LocalDate lastDate = firstDate.plusMonths(3);

    //unclear how the station should be declared just in class
    //private String station;
    private Set<Station> stations;

    //add departure time
    private Timestamp departureTime;

    public Train(int trainID, int number, int availableSeats,
                 String occurence, LocalDate firstDate) {
        this.trainID = trainID;
        this.number = number;
        this.availableSeats = availableSeats;
        this.occurence = occurence;
        this.firstDate=firstDate;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainID=" + trainID +
                ", number=" + number +
                ", availableSeats=" + availableSeats +
                ", occurence='" + occurence + '\'' +

                '}';
    }
}
