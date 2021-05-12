package com.javaschool.ev.service.impl;

import com.javaschool.ev.dao.api.PassengerDAO;
import com.javaschool.ev.dao.impl.PassengerDAOImpl;
import com.javaschool.ev.domain.Passenger;
import com.javaschool.ev.service.api.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    /*
    setter creation, same as in controller
    after istalling session factory in DAOImpl add @Transactional annotation
     */
    private PassengerDAO passengerDAO = new PassengerDAOImpl();
    @Autowired
    public void setPassengerDAO (PassengerDAO passengerDAO){
        this.passengerDAO=passengerDAO;
    }

    @Override
    @Transactional
    public List<Passenger> allPassengers() {
        return passengerDAO.allPassengers();
    }

    @Override
    @Transactional
    public void add(Passenger passenger) {
        passengerDAO.add(passenger);
    }

    @Override
    @Transactional
    public void delete(Passenger passenger) {
        passengerDAO.delete(passenger);
    }

    @Override
    @Transactional
    public void edit(Passenger passenger) {
        passengerDAO.edit(passenger);
    }

    @Override
    @Transactional
    public Passenger getById(int passengerID) {
        return passengerDAO.getById(passengerID);
    }

    @Override
    @Transactional
    public boolean checkPassenger(String firstName, String lastName, Date birthDate) {
        return passengerDAO.checkPassenger(firstName,lastName,birthDate);
    }
}
