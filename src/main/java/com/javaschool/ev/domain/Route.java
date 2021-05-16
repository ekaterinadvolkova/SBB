package com.javaschool.ev.domain;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="route")
public class Route {

    @Id
    @Column(name="routeID")
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routeID;

    @ManyToOne
    @NonNull
    @Column(name = "trainID")
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
