package com.javaschool.ev.dao.impl;

import com.javaschool.ev.dao.api.PassengerDAO;
import com.javaschool.ev.domain.Passenger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PassengerDAOImpl implements PassengerDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Passenger> allPassengers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Passenger").list();
    }

    @Override
    public void add(Passenger passenger) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(passenger);
    }

    @Override
    public void delete(Passenger passenger) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(passenger);
    }

    @Override
    public void edit(Passenger passenger) {
        Session session = sessionFactory.getCurrentSession();

        Passenger dbPassenger = getById(passenger.getPassengerID());

        dbPassenger.setPassengerID(passenger.getPassengerID());
        dbPassenger.setFirstName(passenger.getFirstName());
        dbPassenger.setLastName(passenger.getLastName());
        dbPassenger.setBirthDate(passenger.getBirthDate());

        session.update(dbPassenger);
    }

    @Override
    public Passenger getById(int passengerID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Passenger.class, passengerID);
    }

    @Override
    public boolean checkPassenger(String firstName, String lastName, LocalDate birthDate) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        query = session.createQuery("from Passenger where firstName = :firstName");
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter("birthDate", birthDate);
        return query.list().isEmpty();
    }
}


