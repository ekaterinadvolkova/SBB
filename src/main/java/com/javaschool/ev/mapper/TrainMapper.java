package com.javaschool.ev.mapper;

import com.javaschool.ev.dao.api.StationDAO;
import com.javaschool.ev.domain.Station;
import com.javaschool.ev.domain.Train;
import com.javaschool.ev.dto.TimetableItemDTO;
import com.javaschool.ev.dto.TrainDTO;
import com.javaschool.ev.service.api.PassengerService;
import com.javaschool.ev.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class TrainMapper {

    @Autowired
    private StationDAO stationDAO;
    public void stationDAO (StationDAO stationDAO){
        this.stationDAO=stationDAO;
    }

    public Train convertRecord (TrainDTO trainDTO){

        Train train = new Train();

        train.setNumber((trainDTO.getNumber()));
        train.setAvailableSeats((trainDTO.getAvailableSeats()));
        train.setOccurrence(trainDTO.getOccurence());
        List<TimetableItemDTO> timetableItemDTOS = trainDTO.getTimetable();

        train.setStations(new HashSet<>());
        for(int i=0; i < timetableItemDTOS.size(); i++){
            TimetableItemDTO t = timetableItemDTOS.get(i);
            Station station = stationDAO.getByName(t.getStationName());
            train.getStations().add(station);
        }

        return train;

    }

}
