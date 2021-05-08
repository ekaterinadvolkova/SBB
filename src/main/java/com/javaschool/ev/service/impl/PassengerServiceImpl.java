package com.javaschool.ev.service.impl;

import com.javaschool.ev.dao.api.PassengerDAO;
import com.javaschool.ev.dao.impl.PassengerDAOImpl;
import com.javaschool.ev.domain.Passenger;
import com.javaschool.ev.service.api.PassengerService;
import java.util.List;

public class PassengerServiceImpl implements PassengerService {
    private PassengerDAO passengerDAO = new PassengerDAOImpl();

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
