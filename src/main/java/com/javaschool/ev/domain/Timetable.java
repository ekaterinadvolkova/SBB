package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="timetable")
public class Timetable {
    @Id
    @Column(name="timetableID")
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timetableID;



    @ManyToMany
    @JoinTable(name = "train",
            joinColumns = { @JoinColumn(name = "trainID") },
            inverseJoinColumns = { @JoinColumn(name = "trainID") })
    private Set<Train> trains = new HashSet<Train>();

    @OneToOne
    @NonNull
    @Column(name="stationID")
    private Station stationID;

    @NonNull
    @Column(name="departureTime")
    private Timestamp departureTime;



}
