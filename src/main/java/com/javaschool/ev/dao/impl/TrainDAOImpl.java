package com.javaschool.ev.dao.impl;

import com.javaschool.ev.dao.api.PassengerDAO;
import com.javaschool.ev.dao.api.TrainDAO;
import com.javaschool.ev.domain.Passenger;
import com.javaschool.ev.domain.Train;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainDAOImpl implements TrainDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Train> allTrains() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Train").list();
    }

    @Override
    public void add(Train train) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(train);
    }

    @Override
    public void delete(Train train) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(train);
    }

    @Override
    public void edit(Train train) {
        Session session = sessionFactory.getCurrentSession();
        session.update(train);
    }

    @Override
    public Train getById(int trainID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Train.class, trainID);
    }

    @Override
    public boolean checkTrain(int number) {
        Session session = sessionFactory.getCurrentSession();
        Query query;

        query = session.createQuery("from Train where number = :number");
        query.setParameter("number", number);

        return query.list().isEmpty();
    }
}
