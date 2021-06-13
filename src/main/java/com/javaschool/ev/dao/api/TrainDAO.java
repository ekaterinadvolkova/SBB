package com.javaschool.ev.dao.api;

import com.javaschool.ev.domain.Train;

import java.util.List;

public interface TrainDAO<date> {
    List<Train> allTrains();

    void add(Train train);

    void delete(int train);

    void update(Train train);

    Train getById(int trainID);

    boolean checkTrain(int number);
}
