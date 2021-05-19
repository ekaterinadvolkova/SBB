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
    private int trainID;
    private int number;
    private int availableSeats;
    private Occurence occurence;
    List<TimetableItemDTO> timetable;
    private LocalDate departureDate;

}
