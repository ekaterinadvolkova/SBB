package com.javaschool.ev.dao.api;

import com.javaschool.ev.domain.Station;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class StationDAO {
    private List<Station> stations = Arrays.asList(
            new Station ("Basel"),
            new Station ("Zurich Airport"));

    public List<Station> getAllStations(){
        return stations;
    }

}
