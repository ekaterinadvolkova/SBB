package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;


@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "timetable")
public class Timetable {

    @Id
    @Column(name = "timetableID")
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timetableID;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "stationID")
    private Station stationID;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "routeID")
    private Route routeID;

    @NonNull
    @Column(name = "departureTime")
    private Timestamp departureTime;

    public Timetable(int timetableID, @NonNull Station stationID, @NonNull Route routeID, @NonNull Timestamp departureTime) {
        this.timetableID = timetableID;
        this.stationID = stationID;
        this.routeID = routeID;
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "timetableID=" + timetableID +
                ", stationID=" + stationID +
                ", routeID=" + routeID +
                ", departureTime=" + departureTime +
                '}';
    }
}
