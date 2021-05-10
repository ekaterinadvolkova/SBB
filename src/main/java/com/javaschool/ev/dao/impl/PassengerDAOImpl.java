package com.javaschool.ev.dao.impl;

import com.javaschool.ev.dao.api.PassengerDAO;
import com.javaschool.ev.domain.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PassengerDAOImpl implements PassengerDAO {

    /*
    to store the list the map is used
    to generate id AtomicInteger is used
    fill the map
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);
    private static final Map<Integer, Passenger> passengers = new HashMap<>();
     */

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    /*
    Passenger list
    нужен параметризированный list,  запрос просто на list --> @SuppressWarnings()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Passenger> allPassengers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Passenger").list();
    }

    /*
    passenger add
    Old version:
    passenger.setPassengerID(AUTO_ID.getAndIncrement());
    passengers.put(passenger.getPassengerID(), passenger);
     */
    @Override
    public void add(Passenger passenger) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(passenger);
    }

    /*
    Passenger delete
    Old version:
    passengers.remove(passenger.getPassengerID());
     */
    @Override
    public void delete(Passenger passenger) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(passenger);
    }

    /*
    passenger edit
    Old version:
    passengers.put(passenger.getPassengerID(), passenger);
     */
    @Override
    public void edit(Passenger passenger) {
        Session session = sessionFactory.getCurrentSession();
        session.update(passenger);
    }

    /*
    passenger get by ID
    Old version:
    return passengers.get(passengerID);
     */
    @Override
    public Passenger getById(int passengerID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Passenger.class, passengerID);
    }
}


