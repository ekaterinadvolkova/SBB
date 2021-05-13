package com.javaschool.ev.domain;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="station")
public class Station {

    @Id
    @Column(name="stationID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stationID;

    @Column(name="name")
    private String name;

    public Station(int stationID, String name) {
        this.stationID = stationID;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationID=" + stationID +
                ", name='" + name + '\'' +
                '}';
    }
}
