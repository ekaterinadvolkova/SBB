package com.javaschool.ev.dao.api;

import com.javaschool.ev.domain.Passenger;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class PassengerDAO  /*extends AbstractDAO<Passenger, String>*/{

    private List<Passenger> passengers = Arrays.asList(
            new Passenger("Diana", "Fehr"));


    public List<Passenger> getAllPassengers(){
        return passengers;
    }

}
