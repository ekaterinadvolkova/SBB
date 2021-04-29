package com.javaschool.ev.dao.api;

import com.javaschool.ev.entity.Passenger;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Repository
public class PassengerDAO {
    private List<Passenger> passengers = Arrays.asList(new Passenger("Diana", "Fehr"));

    public List<Passenger> getAllPassengers(){
        return passengers;
    }
}
