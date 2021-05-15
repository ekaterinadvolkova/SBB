package com.javaschool.ev.dto;

import com.javaschool.ev.domain.Station;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter @Setter @NoArgsConstructor
public class TimetableItemDTO {
    private String stationName;
    private Time departureTime;

}
