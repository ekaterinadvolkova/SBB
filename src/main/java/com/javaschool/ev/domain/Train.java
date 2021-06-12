package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "train")
public class Train {

    @Id
    @Column(name = "trainID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainID;

    @NonNull
    @Column(name = "number")
    private int number;

    @NonNull
    @Column(name = "availableSeats")
    private int availableSeats;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimetableItem> timetableItems = new ArrayList<>();

    public void addTimetabelItem(TimetableItem timetableItem) {
        timetableItems.add(timetableItem);
        timetableItem.setTrain(this);
    }

    public void removeTimetableItem(TimetableItem timetableItem) {
        timetableItems.remove(timetableItem);
        timetableItem.setTrain(null);
    }


}
