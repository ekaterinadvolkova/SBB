package com.javaschool.ev.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class TrainDTO {
    private int number;
    private int availableSeats;
    List<TimetableItemDTO> timetable = new ArrayList<>();
    Set<String> stationNames = new HashSet<>();
}
