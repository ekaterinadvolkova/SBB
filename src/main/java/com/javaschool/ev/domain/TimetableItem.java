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
@Table(name = "timetable_item")
public class TimetableItem {

    @Id
    @Column(name = "timetable_id")
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timetableId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id", referencedColumnName = "trainID")
    private Train train;

    @OneToOne
    @NonNull
    @JoinColumn(name = "stationID")
    private Station station;

    @NonNull
    @Column(name = "departureTime")
    private LocalDateTime departureTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimetableItem)) return false;
        return timetableId == ((TimetableItem) o).getTimetableId();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
