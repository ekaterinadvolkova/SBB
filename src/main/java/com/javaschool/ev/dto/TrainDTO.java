package com.javaschool.ev.dto;

import com.javaschool.ev.domain.Occurence;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TrainDTO {
//    private int trainID;
    private int number;
    private int availableSeats;
    private Occurence occurence;
    List<TimetableItemDTO> timetable;
    private LocalDate departureDate;

    public List<TimetableItemDTO> getTimetable() {
        return timetable;
    }

    public void setTimetable(List<TimetableItemDTO> timetable) {
        this.timetable = timetable;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Occurence getOccurence() {
        return occurence;
    }

    public void setOccurence(Occurence occurence) {
        this.occurence = occurence;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
}
