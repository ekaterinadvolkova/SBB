package com.javaschool.ev.mapper;

import com.javaschool.ev.domain.Station;
import com.javaschool.ev.domain.TimetableItem;
import com.javaschool.ev.dto.TimetableItemDTO;
import com.javaschool.ev.service.api.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimetableItemMapper {
    @Autowired
    StationService stationService;

    public TimetableItem convertToTimetableItem(TimetableItemDTO timetableItemDTO) {
        TimetableItem timetableItem = new TimetableItem();
        Station station = stationService.getByName(timetableItemDTO.getStationName());

        timetableItem.setStation(station);
        timetableItem.setDepartureTime(timetableItemDTO.toLocalDateTime());
        return timetableItem;
    }

    public TimetableItemDTO convertToDTO(TimetableItem timetableItem) {
        TimetableItemDTO dto = new TimetableItemDTO();

        dto.setStationName(timetableItem.getStation().getName());
        dto.fromLocalDateTime(timetableItem.getDepartureTime());
        return dto;
    }
}
