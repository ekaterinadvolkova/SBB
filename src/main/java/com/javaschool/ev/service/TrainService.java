package com.javaschool.ev.service;

import com.javaschool.ev.dao.api.PassengerDAO;
import com.javaschool.ev.dao.api.TrainDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {
    @Autowired
    private TrainDAO trainDAO;
    public List getAllTrains (){
        return trainDAO.getAllTrains();
    }
}
