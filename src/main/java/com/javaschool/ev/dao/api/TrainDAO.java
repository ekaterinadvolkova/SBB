package com.javaschool.ev.dao.api;

import com.javaschool.ev.domain.Train;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class TrainDAO  /*extends AbstractDAO<Passenger, String>*/{

    private List<Train> trains = Arrays.asList(
            new Train(1150, 300, 100, "daily"),
    new Train(11, 3, 1, "weekly"));

    public List<Train> getAllTrains(){
        return trains;
    }

}