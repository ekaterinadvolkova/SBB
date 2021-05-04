package com.javaschool.ev.controller;

import com.javaschool.ev.domain.Passenger;
import com.javaschool.ev.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping("/passenger")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }


    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validatePassenger() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("passengerFromServer", new Passenger());
        modelAndView.setViewName("passenger_check");
        return modelAndView;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody
    String checkPassenger(@ModelAttribute("passengerFromServer") Passenger passenger) {
        if ("Diana".equals(passenger.getFirstName()) && "Fehr".equals(passenger.getLastName())) {
            return "valid";
        }
        return "invalid";
    }
}


