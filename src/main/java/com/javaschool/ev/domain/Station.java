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
@Table(name = "station")
public class Station {

    @Id
    @Column(name = "stationID")
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stationID;

    @NonNull
    @Column(name = "name")
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
