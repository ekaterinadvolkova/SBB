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
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "ticketID")
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketID;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id", referencedColumnName = "train_id")
    private Train train;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;


    public Ticket(int ticketID) {
        this.ticketID = ticketID;

    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketID=" + ticketID +

                '}';
    }

    public void setUser(User user) {
        this.user=user;
    }
}
