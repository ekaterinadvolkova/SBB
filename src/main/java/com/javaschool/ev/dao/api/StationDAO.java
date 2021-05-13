package com.javaschool.ev.dao.api;

import com.javaschool.ev.domain.Passenger;
import com.javaschool.ev.domain.Station;

import java.util.List;

public interface StationDAO {

    List<Passenger> allStations();
    void add(Station station);
    void delete(Station station);
    void edit(Station station);
    Station getById(int stationID);
    boolean checkStation(String name);

}
