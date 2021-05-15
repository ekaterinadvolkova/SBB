package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

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
    @Column(name="bookedSeats")
    private int bookedSeats;

    @NonNull
    @Column(name="occurence")
    private String occurence;

    /*@ManyToMany
    @JoinTable(name = "ticket",
            joinColumns = { @JoinColumn(name = "ticketID") },
            inverseJoinColumns = { @JoinColumn(name = "ticketID") })
    private Set<Ticket> trains = new HashSet<Ticket>();*/



    public Train(int trainID, int number, int availableSeats, int bookedSeats,
                 String occurence, LocalDate localDate) {
        this.trainID = trainID;
        this.number = number;
        this.availableSeats = availableSeats;
        this.bookedSeats = bookedSeats;
        this.occurence = occurence;

    }

    @Override
    public String toString() {
        return "Train{" +
                "trainID=" + trainID +
                ", number=" + number +
                ", availableSeats=" + availableSeats +
                ", bookedSeats=" + bookedSeats +
                ", occurence='" + occurence + '\'' +

                '}';
    }
}
