package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @Column(name = "seatID")
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatID;

    @Column(name = "number")
    private int number;

    public Seat(int seatID, int number) {
        this.seatID = seatID;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatID=" + seatID +
                ", number=" + number +
                '}';
    }
}
