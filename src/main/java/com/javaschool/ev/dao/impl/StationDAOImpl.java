package com.javaschool.ev.dao.impl;

import com.javaschool.ev.dao.api.StationDAO;
import com.javaschool.ev.domain.Station;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class StationDAOImpl implements StationDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Station> allStations() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Station").list();
    }

    @Override
    public Station add(Station station) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(station);
        return station;
    }

    @Override
    public void delete(Station station) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(station);
    }

    @Override
    public void edit(Station station) {
        Session session = sessionFactory.getCurrentSession();
        Station dbStation = getById(station.getStationID());
        dbStation.setStationID((station.getStationID()));
        dbStation.setName(station.getName());
        session.update(dbStation);
    }

    @Override
    public Station getById(int stationID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Station.class, stationID);
    }

    @Override
    public boolean doesStationExist(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        query = session.createQuery("from Station where name = :name");
        query.setParameter("name", name);
        List<Station> result = query.getResultList();
        return !result.isEmpty();
    }

    @Override
    public Station getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query;
        query = session.createQuery("from Station where name = :name");
        query.setParameter("name", name);
//        if (!query.list().isEmpty()) {
//            return (Station) query.list().get(0);
//        }

        return (Station) query.list().get(0);
    }
}
