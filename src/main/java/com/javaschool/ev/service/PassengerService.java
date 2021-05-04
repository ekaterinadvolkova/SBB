package com.javaschool.ev.service;

import com.javaschool.ev.dao.api.PassengerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerDAO passengerDAO;
    public List getAllPassengers (){
        return passengerDAO.getAllPassengers();
    }


}
