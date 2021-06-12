package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDateTime;

@Repository
@Getter
@Setter
@NoArgsConstructor
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

    @NonNull
    @Column(name = "departureTime")
    private LocalDateTime departureTime;

}
