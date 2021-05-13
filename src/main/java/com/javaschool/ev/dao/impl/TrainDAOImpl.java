package com.javaschool.ev.dao.impl;

import com.javaschool.ev.dao.api.TrainDAO;
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

        Train dbTrain =getById(train.getTrainID());
        dbTrain.setOccurence((dbTrain.getOccurence()));

        session.update(dbTrain);
        //session.update(train);
    }

    @Override
    public Train getById(int trainID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Train.class, trainID);
    }

    @Override
    public boolean checkTrain(int number, int availableSeats, int bookedSeats, String occurence) {
        Session session = sessionFactory.openSession();

        Query query;
        query = session.createQuery("from Train where number = :number");
        query.setParameter("number", number);

        query = session.createQuery("from Train where availableSeats = :availableSeats");
        query.setParameter("availableSeats", availableSeats);

        query = session.createQuery("from Train where bookedSeats = :bookedSeats");
        query.setParameter("bookedSeats", bookedSeats);

        query = session.createQuery("from Train where occurence = :occurence");
        query.setParameter("occurence", occurence);

        return query.list().isEmpty();
    }
}
