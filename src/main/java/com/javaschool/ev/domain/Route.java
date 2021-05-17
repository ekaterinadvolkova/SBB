package com.javaschool.ev.domain;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="route")
public class Route {

    @Id
    @Column(name="routeID")
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routeID;

    @Column(name = "date")
    @NonNull
    private LocalDate date;


    @ManyToOne
    @NonNull
    @JoinColumn(name = "trainID")
    private Train train;

    public Route(int routeID,  Train train) {
        this.routeID = routeID;
        this.train = train;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeID=" + routeID +
                ", trainID=" + train +
                '}';
    }
}
