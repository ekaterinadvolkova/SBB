package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="ticket")
public class Ticket {

    @Id
    @Column(name="ticketID")
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketID;


    @ManyToOne
    @JoinColumn(name = "passengerID")
    @NonNull
    private Passenger passengerID;


    @ManyToMany
    @JoinTable(name = "train",
            joinColumns = { @JoinColumn(name = "trainID") },
            inverseJoinColumns = { @JoinColumn(name = "trainID") })
    private Set<Train> authors = new HashSet<Train>();



}
