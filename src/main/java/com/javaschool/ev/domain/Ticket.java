package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import javax.persistence.*;


@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="ticket")
public class Ticket {

    @Id
    @Column(name="ticketID")
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketID;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "passengerID")
    @NonNull
    private Passenger passenger;

    @ManyToOne
    @Column(name="routeID")
    @NonNull
    private Route routeID;

    @ManyToOne
    @Column(name="seatID")
    @NonNull
    private Seat number;


    public Ticket(int ticketID, @NonNull Passenger passenger, @NonNull Seat number, Route routeID) {
        this.ticketID = ticketID;
        this.passenger = passenger;
        this.number = number;
        this.routeID = routeID;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +
                ", passenger=" + passenger +
                ", routeID=" + routeID +
                ", number=" + number +
                '}';
    }
}
