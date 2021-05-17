package com.javaschool.ev.dao.impl;

import com.javaschool.ev.dao.api.RouteDAO;
import com.javaschool.ev.domain.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RouteDAOImpl implements RouteDAO {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void createNewRoute(Route route) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(route);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Route> getAllRoutes() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Route> routes = null;
        try {
            Query query = entityManager.createQuery("SELECT t FROM Route t");
            routes = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return routes;
    }

    public List<Route> getTrainRoutes(int trainID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Route> routes = null;
        try {
            Query query = entityManager
                    .createQuery("SELECT r FROM Route r JOIN FETCH r.trainID WHERE r.trainID  = :trainID", Route.class)
                    .setParameter("trainID", trainID);
            routes = query.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
        return routes;
    }

    @Override
    public Route getRouteById(int routeID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Route route = null;
        try {
            Query query = entityManager
                    .createQuery("SELECT r FROM Route r WHERE r.routeID  = :routeID", Route.class)
                    .setParameter("routeID", routeID);
            route = (Route) query.getSingleResult();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
        return route;
    }

    @Override
    public void deleteRoute(int routeID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Route route = entityManager.find(Route.class, routeID);
            entityManager.remove(route);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }

    }

    @Override
    public void editRoute(Route route) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(route);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

}

