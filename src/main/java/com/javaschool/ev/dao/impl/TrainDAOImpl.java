package com.javaschool.ev.dao.impl;

import com.javaschool.ev.dao.api.TrainDAO;
import com.javaschool.ev.domain.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TrainDAOImpl implements TrainDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Train> allTrains(String stationName) {
        Session session = sessionFactory.getCurrentSession();

        if(null == stationName) {
            return session.createQuery("from Train").list();
        } else {
            Query queryTimetableItems = session.createQuery("select item.train from TimetableItem item" +
                    " where item.station=(select station from Station station where station.name=:stationName)");
            queryTimetableItems.setParameter("stationName", stationName);
            return queryTimetableItems.list();
        }
    }

    @Override
    public void add(Train train) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(train);
    }

    @Override
    public void delete(int trainId) {
        Session session = sessionFactory.getCurrentSession();
        Train train = getById(trainId);

        if (null != train) {
            session.delete(train);
        }
    }

    @Override
    public void update(Train train) {
        Session session = sessionFactory.getCurrentSession();
        Train existing = getById(train.getTrainId());

        if (null != existing) {
            existing.setNumber(train.getNumber());
            existing.setAvailableSeats(existing.getAvailableSeats());

            // clear existing items
            existing.getTimetableItems().clear();

            // replace them with new items
            for (TimetableItem item : train.getTimetableItems()) {
                existing.addTimetableItem(item);
            }
            session.update(existing);

        }
    }

    @Override
    public Train getById(int trainID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Train.class, trainID);
    }

    @Override
    public boolean checkTrain(int number) {
        Session session = sessionFactory.openSession();

        Query query;
        query = session.createQuery("from Train where number = :number");
        query.setParameter("number", number);
        return query.list().isEmpty();
    }

    @Override
    public void addTicket(int userId, int trainID) {
        Session session = sessionFactory.getCurrentSession();

        User user = session.get(User.class, userId);

        Ticket ticket = new Ticket();
        ticket.setUser(user);

        Train train = getById(trainID);
        train.addTicket(ticket);
        session.update(train);
    }

    //allTrains ofor station
    //station id
    //query select from train where trainID in (select trainID from timetableItems where stationID = XXX)
}
