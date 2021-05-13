package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="train")
public class train {

    @Id
    @Column(name="trainID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainID;

    @Column(name="number")
    private int number;

    @Column(name="bookedSeats")
    private int bookedSeats;

    @Column(name="occurence")
    private String occurence;

    public train(int trainID, int number, int bookedSeats, String occurence) {
        this.trainID = trainID;
        this.number = number;
        this.bookedSeats = bookedSeats;
        this.occurence = occurence;
    }

    @Override
    public String toString() {
        return "train{" +
                "trainID=" + trainID +
                ", number=" + number +
                ", bookedSeats=" + bookedSeats +
                ", occurence='" + occurence + '\'' +
                '}';
    }
}
