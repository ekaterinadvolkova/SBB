package com.javaschool.ev.service.api;

import com.javaschool.ev.dto.TrainDTO;

import java.util.List;

public interface TrainService {
    List<TrainDTO> allTrains();

    void add(TrainDTO trainDTO);

    void delete(int trainId);

    void update(TrainDTO trainDTO);

    TrainDTO getById(int trainID);

    List<String> validateTrain(TrainDTO trainDTO);

    boolean checkTrain(int number);
}
