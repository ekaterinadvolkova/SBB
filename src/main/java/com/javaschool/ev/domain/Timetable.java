package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "train_to_timetable",
            joinColumns = {@JoinColumn(name = "timetableID", referencedColumnName = "timetableID")},
            inverseJoinColumns = {@JoinColumn(name = "trainID", referencedColumnName = "trainID")})
    private Set<Train> trains = new HashSet<Train>();

    @OneToOne
    @NonNull
    @JoinColumn(name = "stationID")
    private Station stationID;

    @NonNull
    @Column(name = "departureTime")
    private Timestamp departureTime;

}
