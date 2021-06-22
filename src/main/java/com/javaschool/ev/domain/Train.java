package com.javaschool.ev.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "train")
public class Train {

    @Id
    @Column(name = "train_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainId;

    @NonNull
    @Column(name = "train_number")
    private int number;

    @NonNull
    @Column(name = "availableSeats")
    private int availableSeats;

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TimetableItem> timetableItems = new ArrayList<>();

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> ticketList = new ArrayList<>();

    public void addTimetableItem(TimetableItem timetableItem) {
        timetableItems.add(timetableItem);
        timetableItem.setTrain(this);
    }

    public void removeTimetableItem(TimetableItem timetableItem) {
        timetableItems.remove(timetableItem);
        timetableItem.setTrain(null);
    }

    public void addTicket(Ticket ticket) {
        ticketList.add(ticket);
        ticket.setTrain(this);
    }

    public void removeTicket(Ticket ticket) {
        ticketList.remove(ticket);
    }


}
