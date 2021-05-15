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

    @SuppressWarnings("unchecked")
    public List<Passenger> allPassengers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Passenger")/*.setFirstResult(10 * (page - 1)).setMaxResults(10)*/.list();
    }

    /*
    Pagination:
    I.e., if this is page 1, output a maximum of 10 records, starting from page 0, and if this is page 5,
    then 10 records starting from page 40
    (the numbering in the database starts with 0).

    public int passengersCount() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select count(*) from Passenger", Number.class).getSingleResult().intValue();
    }*/

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

        Passenger dbPassenger=getById(passenger.getPassengerID());
        dbPassenger.setFirstName(passenger.getFirstName());
        dbPassenger.setLastName(passenger.getLastName());
        dbPassenger.setBirthDate(passenger.getBirthDate());

        session.update(dbPassenger);
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

    @Override
    public boolean checkPassenger(String firstName, String lastName, LocalDate birthDate) {
        Session session = sessionFactory.getCurrentSession();
        Query query;

        query = session.createQuery("from Passenger where firstName = :firstName");
        query.setParameter("firstName", firstName);

        query = session.createQuery("from Passenger where lastName = :lastName");
        query.setParameter("lastName", lastName);

        query = session.createQuery("from Passenger where birthDate = :birthDate");
        query.setParameter("birthDate", birthDate);

        return query.list().isEmpty();
    }
}


