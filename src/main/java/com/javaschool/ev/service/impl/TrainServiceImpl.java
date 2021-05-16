package com.javaschool.ev.service.impl;

import com.javaschool.ev.dao.api.TrainDAO;
import com.javaschool.ev.dao.impl.TrainDAOImpl;
import com.javaschool.ev.domain.Train;
import com.javaschool.ev.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    private TrainDAO trainDAO = new TrainDAOImpl();
    @Autowired
    public void setTrainDAO (TrainDAO trainDAO){
        this.trainDAO=trainDAO;
    }

    @Override
    @Transactional
    public List<Train> allTrains() {
        return trainDAO.allTrains();
    }

    @Override
    @Transactional
    public void add(Train train) {
        trainDAO.add(train);
    }

    @Override
    public void delete(Train train) {
        trainDAO.delete(train);
    }

    @Override
    @Transactional
    public void edit(Train train) {
        trainDAO.edit(train);
    }

    @Override
    @Transactional
    public Train getById(int trainID) {
        return trainDAO.getById(trainID);
    }

    @Override
    @Transactional
    public boolean checkTrain(int number, int availableSeats, String occurence) {
        return trainDAO.checkTrain(number, availableSeats, occurence);
    }
}
