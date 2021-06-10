package com.javaschool.ev.dao.impl;

import com.javaschool.ev.dao.api.TimetableDAO;
import com.javaschool.ev.domain.Timetable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TimetableDAOImpl implements TimetableDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void createNewTimetableItem(Timetable timetableItem) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(timetableItem);
    }

    @Override
    public List<Timetable> getAllTimetableItems() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable").list();
    }


    @Override
    public void deleteTimetableItem(Timetable timetableItem) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(timetableItem);
    }

    @Override
    public void editTimetableItem(Timetable timetableItem) {
        Session session = sessionFactory.getCurrentSession();
        Timetable dbTimetable = getById(timetableItem.getTimetableID());
        dbTimetable.setStation(timetableItem.getStation());
        dbTimetable.setRoute(timetableItem.getRoute());
        dbTimetable.setDepartureTime(timetableItem.getDepartureTime());
        session.update(dbTimetable);
    }

    @Override
    public Timetable getById(int timetableID) {
        Session session = sessionFactory.getCurrentSession();
        return session.getReference(Timetable.class, timetableID);
    }
}
