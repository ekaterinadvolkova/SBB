package com.javaschool.ev.service.impl;

import com.javaschool.ev.dao.api.StationDAO;
import com.javaschool.ev.dao.api.TrainDAO;
import com.javaschool.ev.dao.impl.TrainDAOImpl;
import com.javaschool.ev.domain.Route;
import com.javaschool.ev.domain.Train;
import com.javaschool.ev.dto.TrainDTO;
import com.javaschool.ev.mapper.TrainMapper;
import com.javaschool.ev.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class TrainServiceImpl implements TrainService {

    @Autowired
    private TrainMapper trainMapper;
    public void trainMapper (TrainMapper trainMapper){
        this.trainMapper=trainMapper;
    }

    private TrainDAO trainDAO = new TrainDAOImpl();
    @Autowired
    public void setTrainDAO (TrainDAO trainDAO){
        this.trainDAO=trainDAO;
    }

    @Override
    public List<Train> allTrains() {
        return trainDAO.allTrains();
    }

    @Override
    public void add(TrainDTO trainDTO) {
        Train train = trainMapper.convertRecord(trainDTO);
        trainDAO.add(train);
    }

    @Override
    public void delete(Train train) {
        trainDAO.delete(train);
    }

    @Override
    public void edit(Train train) {
        trainDAO.edit(train);
    }

    @Override
    public Train getById(int trainID) {
        return trainDAO.getById(trainID);
    }

    @Override
    public boolean checkTrain(int number) {
        return trainDAO.checkTrain(number);
    }


}
