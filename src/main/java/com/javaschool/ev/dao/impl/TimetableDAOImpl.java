package com.javaschool.ev.dao.impl;

import com.javaschool.ev.dao.api.TimetableDAO;
import com.javaschool.ev.domain.Timetable;
import com.javaschool.ev.domain.Train;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class TimetableDAOImpl implements TimetableDAO{

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void createNewTimetableItem(Timetable timetableItem) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(timetableItem);
            transaction.commit();
        }
        catch (Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Timetable> getAllTimetableItems() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = (Query) entityManager.createQuery("SELECT t FROM Timetable t");

        List<Timetable> timetableItems = query.getResultList();
        entityManager.close();
        return timetableItems;
    }

    @Override
    public void deleteTimetableItem(int timetableID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Timetable timetableItem = entityManager.find(Timetable.class, timetableID);
            entityManager.remove(timetableItem);
            transaction.commit();
        }
        catch (Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void editTimetableItem(Timetable timetableItem) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(timetableItem);
            transaction.commit();
        }
        catch (Exception ex){
            if(transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Timetable getById(int timetableID) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Timetable.class, timetableID);
    }
}
