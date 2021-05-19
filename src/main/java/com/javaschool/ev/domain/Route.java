package com.javaschool.ev.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="route")
public class Route {

    @Id
    @Column(name="routeID")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int routeID;

    @Column(name = "departure_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @NonNull
    private LocalDate date;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "trainID")
    private Train train;

    @OneToMany(mappedBy = "route")
    List<Timetable> timetableList;


    public Route(int routeID,  Train train) {
        this.routeID = routeID;
        this.train = train;
    }

}
