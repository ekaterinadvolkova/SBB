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
    // fields matching DAO
    private Integer trainId;
    private int number;
    private int availableSeats;
    List<TimetableItemDTO> timetable = new ArrayList<>();

    // extra fields for frontend only
    private String trainName;
    private List<String> errors;
    private boolean isUpdated = false;
    Set<String> stationNames = new HashSet<>();
}
