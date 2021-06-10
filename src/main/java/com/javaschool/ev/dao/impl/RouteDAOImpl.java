package com.javaschool.ev.dao.impl;

import com.javaschool.ev.dao.api.RouteDAO;
import com.javaschool.ev.domain.Route;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RouteDAOImpl implements RouteDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void createNewRoute(Route route) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(route);
    }

    @Override
    public List<Route> getAllRoutes() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Route").list();

    }

    public List<Route> getTrainRoutes(int trainID) {
        Session session = sessionFactory.getCurrentSession();

        List<Route> routes = null;
        Query query = session
                .createQuery("SELECT r FROM Route r JOIN FETCH r.train WHERE r.train  = :trainID", Route.class)
                .setParameter("trainID", trainID);
        routes = query.getResultList();

        return routes;
    }

    @Override
    public Route getRouteById(int routeID) {
        Session session = sessionFactory.getCurrentSession();
        return session.getReference(Route.class, routeID);
    }

    @Override
    public void deleteRoute(Route route) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(route);
    }

    @Override
    public void editRoute(Route route) {
        Session session = sessionFactory.getCurrentSession();
        Route dbRoute = getRouteById(route.getRouteID());
        dbRoute.setTimetableList(route.getTimetableList());
        dbRoute.setTrain(route.getTrain());
        dbRoute.setDate(route.getDate());
        dbRoute.setTrain(route.getTrain());
        session.update(dbRoute);
    }
}

