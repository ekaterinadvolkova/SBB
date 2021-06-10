package com.javaschool.ev.dao.api;

import com.javaschool.ev.domain.Station;

import java.util.List;

public interface StationDAO {

    List<Station> allStations();
    Station add(Station station);
    void delete(Station station);
    void edit(Station station);
    Station getById(int stationID);
    boolean doesStationExist(String name);
    Station getByName(String name);

}
