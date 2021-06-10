package com.javaschool.ev.service.api;

import com.javaschool.ev.domain.Train;
import com.javaschool.ev.dto.TrainDTO;

import java.util.List;

public interface TrainService {
    List<Train> allTrains();

    void add(TrainDTO trainDTO);

    void delete(Train train);

    void edit(Train train);

    Train getById(int trainID);

    boolean checkTrain(int number);

}
