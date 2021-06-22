package com.javaschool.ev.service.api;

import com.javaschool.ev.domain.Ticket;
import com.javaschool.ev.domain.Train;
import com.javaschool.ev.dto.TrainDTO;

import java.util.List;

public interface TrainService {
    List<TrainDTO> allTrains(String stationName);
    void add(TrainDTO trainDTO);
    void delete(int trainId);
    void update(TrainDTO trainDTO);
    TrainDTO getById(int trainID);
    TrainDTO updateStationNames(TrainDTO trainDTO);
    List<String> validateTrain(TrainDTO trainDTO);
    boolean checkTrain(int number);
    List<String> addTicket (int trainID, int userID);
}
