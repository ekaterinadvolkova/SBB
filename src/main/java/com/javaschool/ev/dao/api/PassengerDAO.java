package com.javaschool.ev.dao.api;

import com.javaschool.ev.domain.Passenger;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PassengerDAO<date> {
    List<Passenger> allPassengers();
    void add(Passenger passenger);
    void delete(Passenger passenger);
    void edit(Passenger passenger);
    Passenger getById(int passengerID);
    boolean checkPassenger(String firstName, String lastName, LocalDate birthDate);
}
