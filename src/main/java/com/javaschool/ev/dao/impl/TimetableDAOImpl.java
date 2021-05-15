package com.javaschool.ev.dao.impl;

import com.javaschool.ev.domain.Station;
import com.javaschool.ev.domain.Timetable;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;

public class TimetableDAOImpl {

    //выбрать станицю и показть список поездов на ней //getBoardForStation

    /*@PersistenceContext
    public List<Timetable> getTimetableforStation (Station station, Timestamp after, Timestamp before){
        String queryString = "SELECT b FROM Board b WHERE b.station = :station and b.departureTime >= :after and " +
                "b.arriveTime <= :before";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("station", station);
        query.setParameter("before", before);
        query.setParameter("after", after);
        return query.getResultList();
    }*/

    //search for train

}
