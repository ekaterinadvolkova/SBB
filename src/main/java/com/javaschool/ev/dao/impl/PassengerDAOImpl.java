package com.javaschool.ev.dao.impl;

import com.javaschool.ev.dao.api.PassengerDAO;
import com.javaschool.ev.domain.Passenger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PassengerDAOImpl implements PassengerDAO {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static Map<Integer, Passenger> passengers = new HashMap<>();

    static {
        Passenger passenger1 = new Passenger();
        passenger1.setPassengerID(AUTO_ID.getAndIncrement());
        passenger1.setFirstName("Anna");
        passenger1.setLastName("Middleton");
        passenger1.setBirthDate("19-04-1997");
        passengers.put(passenger1.getPassengerID(), passenger1);
    }


    @Override
    public List<Passenger> allPassengers() {
        return new ArrayList<>(passengers.values());
    }

    @Override
    public void add(Passenger passenger) {
        passenger.setPassengerID(AUTO_ID.getAndIncrement());
        passengers.put(passenger.getPassengerID(), passenger);
    }

    @Override
    public void delete(Passenger passenger) {
        passengers.remove(passenger.getPassengerID());
    }

    @Override
    public void edit(Passenger passenger) {
        passengers.put(passenger.getPassengerID(), passenger);

    }

    @Override
    public Passenger getById(int passengerID) {
        return passengers.get(passengerID);
    }
}
