package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "train_to_station",
            joinColumns = @JoinColumn(name = "trainID"),
            inverseJoinColumns = @JoinColumn(name = "stationID")
    )
    private Set<Station> stations;

    public Train(int trainID, int number) {
        this.trainID = trainID;
        this.number = number;
    }


}
