package com.javaschool.ev.service.api;

import com.javaschool.ev.domain.Station;

import java.util.List;
import java.util.Set;

public interface StationService {

    List<Station> allStations();

    void add(Station station);

    void delete(Station station);

    void edit(Station station);

    Station getById(int stationID);

    boolean doesStationExist(String name);

    Station getByName(String name);

    Set<String> getAvailableStationNames(boolean addAllSelector);
}
