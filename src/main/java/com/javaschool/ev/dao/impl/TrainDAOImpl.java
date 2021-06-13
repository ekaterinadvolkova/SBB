package com.javaschool.ev.dao.impl;

import com.javaschool.ev.dao.api.TrainDAO;
import com.javaschool.ev.domain.TimetableItem;
import com.javaschool.ev.domain.Train;
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
        Train existing = getById(train.getTrainID());

        if (null != existing) {
            existing.setNumber(train.getNumber());
            existing.setAvailableSeats(existing.getAvailableSeats());

            // clear existing items
            existing.getTimetableItems().clear();

            // replace them with new items
            for (TimetableItem item : train.getTimetableItems()) {
                existing.addTimetabelItem(item);
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
}
