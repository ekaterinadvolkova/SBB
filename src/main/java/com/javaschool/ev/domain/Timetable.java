package com.javaschool.ev.domain;

import com.javaschool.ev.dto.TimetableItemDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
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
    private Station station;

    @ManyToOne

    @JoinColumn(name = "routeID")
    private Route route;

    @NonNull
    @Column(name = "departureTime")
    private LocalDateTime departureTime;

    public void setRoute(@NonNull Route route) {
        this.route = route;
    }




}
