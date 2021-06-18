package com.javaschool.ev.mapper;

import com.javaschool.ev.domain.TimetableItem;
import com.javaschool.ev.domain.Train;
import com.javaschool.ev.dto.TimetableItemDTO;
import com.javaschool.ev.dto.TrainDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrainMapper {
    @Autowired
    TimetableItemMapper timetableItemMapper;

    public Train convertToTrain(TrainDTO trainDTO) {

        Train train = new Train();

        if(null != trainDTO.getTrainId()) {
            train.setTrainId(trainDTO.getTrainId());
        }
        train.setNumber(trainDTO.getNumber());
        train.setAvailableSeats(trainDTO.getAvailableSeats());
        for(TimetableItemDTO timetableItemDTO : trainDTO.getTimetable()) {
            train.addTimetableItem(timetableItemMapper.convertToTimetableItem(timetableItemDTO));
        }
        return train;
    }

    public TrainDTO convertToDto(Train train) {

        TrainDTO dto = new TrainDTO();

        dto.setTrainId(train.getTrainId());
        dto.setNumber(train.getNumber());
        dto.setAvailableSeats(train.getAvailableSeats());
        List<TimetableItemDTO> timetableItemDTOS = new ArrayList<>();
        for(TimetableItem item :train.getTimetableItems()) {
            timetableItemDTOS.add(timetableItemMapper.convertToDto(item));
        }
        dto.setTimetable(timetableItemDTOS);

        //for departure time on welcome page
        //timetableItemDTOS.get(0).getDepartureDateTime();
        dto.getTimetable().get(0).getDepartureDateTime();

        dto.setTrainName(dto.getTimetable().get(0).getStationName() + " - " +
                dto.getTimetable().get(dto.getTimetable().size() -1).getStationName());
        return dto;
    }

}
