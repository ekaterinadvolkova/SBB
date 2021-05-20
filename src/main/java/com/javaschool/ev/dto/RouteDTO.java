package com.javaschool.ev.dto;

import com.javaschool.ev.domain.Route;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RouteDTO {
    private Route date;

    List<TimetableItemDTO> timetable;
}
