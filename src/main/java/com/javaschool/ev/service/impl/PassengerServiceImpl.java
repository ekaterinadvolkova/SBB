package com.javaschool.ev.service.impl;

import com.javaschool.ev.dao.api.PassengerDAO;
import com.javaschool.ev.dao.impl.PassengerDAOImpl;
import com.javaschool.ev.domain.Passenger;
import com.javaschool.ev.service.api.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    /*
    setter creation, same as in controller
     */
    private PassengerDAO passengerDAO = new PassengerDAOImpl();
    @Autowired
    public void setPassengerDAO (PassengerDAO passengerDAO){
        this.passengerDAO=passengerDAO;
    }

    @Override
    public List<Passenger> allPassengers() {
        return passengerDAO.allPassengers();
    }

    @Override
    public void add(Passenger passenger) {
        passengerDAO.add(passenger);
    }

    @Override
    public void delete(Passenger passenger) {
        passengerDAO.delete(passenger);
    }

    @Override
    public void edit(Passenger passenger) {
        passengerDAO.edit(passenger);
    }

    @Override
    public Passenger getById(int passengerID) {
        return passengerDAO.getById(passengerID);
    }
}
