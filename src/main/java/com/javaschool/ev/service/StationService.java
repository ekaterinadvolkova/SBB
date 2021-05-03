package com.javaschool.ev.service;

import com.javaschool.ev.dao.api.StationDAO;
import com.javaschool.ev.dao.api.TrainDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {
    @Autowired
    private StationDAO stationDAO;
    public List getAllStations (){
        return stationDAO.getAllStations();
    }
}
