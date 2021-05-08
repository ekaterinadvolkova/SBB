package com.javaschool.ev.dao.impl;

import com.javaschool.ev.dao.api.PassengerDAO;
import com.javaschool.ev.domain.Passenger;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PassengerDAOImpl implements PassengerDAO {

    /*
    to store the list the map is used
    to generate id AtomicInteger is used
    fill the map
     */
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static final Map<Integer, Passenger> passengers = new HashMap<>();

    /*
    create 2 test passengers in DAOImpl
     */
    static {
        Passenger passenger1 = new Passenger();
        passenger1.setPassengerID(AUTO_ID.getAndIncrement());
        passenger1.setFirstName("Ann");
        passenger1.setLastName("Rowling");
        passenger1.setBirthDate("19-04-1997");
        passengers.put(passenger1.getPassengerID(), passenger1);

        Passenger passenger2 = new Passenger();
        passenger2.setPassengerID(AUTO_ID.getAndIncrement());
        passenger2.setFirstName("Diana");
        passenger2.setLastName("Fhr");
        passenger2.setBirthDate("12-10-2005");
        passengers.put(passenger2.getPassengerID(), passenger2);

    }


    /*
    Passenger list
     */
    @Override
    public List<Passenger> allPassengers() {
        return new ArrayList<>(passengers.values());
    }

    /*
    passenger add
     */
    @Override
    public void add(Passenger passenger) {
        passenger.setPassengerID(AUTO_ID.getAndIncrement());
        passengers.put(passenger.getPassengerID(), passenger);
    }

    /*
    Passenger delete
     */
    @Override
    public void delete(Passenger passenger) {
        passengers.remove(passenger.getPassengerID());
    }

    /*
    passenger edit
     */
    @Override
    public void edit(Passenger passenger) {
        passengers.put(passenger.getPassengerID(), passenger);
    }

    /*
    passenger get by ID
     */
    @Override
    public Passenger getById(int passengerID) {
        return passengers.get(passengerID);
    }
}
