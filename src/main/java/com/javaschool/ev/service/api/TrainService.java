package com.javaschool.ev.service.api;

import com.javaschool.ev.domain.Train;
import java.util.List;

public interface TrainService {
    List<Train> allTrains();
    void add(Train train);
    void delete(Train train);
    void edit(Train train);
    Train getById(int trainID);

    boolean checkTrain(int number);
}
