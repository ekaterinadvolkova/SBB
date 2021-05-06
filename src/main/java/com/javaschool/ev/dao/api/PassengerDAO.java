package com.javaschool.ev.dao.api;

import com.javaschool.ev.domain.Passenger;
import java.util.List;

public interface PassengerDAO {
    List<Passenger> allPassengers();
    void add(Passenger passenger);
    void delete(Passenger passenger);
    void edit(Passenger passenger);
    Passenger getById(int passengerID);
}
