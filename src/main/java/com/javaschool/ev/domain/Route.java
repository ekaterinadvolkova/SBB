package com.javaschool.ev.domain;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="route")
public class Route {

    @Id
    @Column(name="routeID")
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routeID;

    @Column(name = "firstDate") @NonNull
    private LocalDate firstDate;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "trainID")
    private Train trainID;

    public Route(int routeID,  Train trainID) {
        this.routeID = routeID;
        this.trainID = trainID;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeID=" + routeID +
                ", trainID=" + trainID +
                '}';
    }
}
