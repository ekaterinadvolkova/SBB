package com.javaschool.ev.controller;

import com.javaschool.ev.domain.Passenger;
import com.javaschool.ev.service.api.PassengerService;
import com.javaschool.ev.service.impl.PassengerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PassengerController {

    private PassengerService passengerService = new PassengerServiceImpl();

    //all passengers list in a table
    @RequestMapping(/*value = "/", */method = RequestMethod.GET)
    public ModelAndView allPassengers() {
        List<Passenger> passengers = passengerService.allPassengers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("passengers");
        modelAndView.addObject("passengerList", passengers);
        return modelAndView;
    }

    // get to the EditPassenger without ID
    @RequestMapping(value = "/editPassenger", method = RequestMethod.GET)
    public ModelAndView editPassenger() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPassenger");
        return modelAndView;
    }

    //get to the EditPassenger Page with ID
    @RequestMapping(value = "/editPassenger/{passengerID}", method = RequestMethod.GET)
    public ModelAndView editPassenger(@PathVariable("passengerID") int passengerID) {
        Passenger passenger = passengerService.getById(passengerID);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPassenger");
        /*modelAndView.addObject("passenger", passenger);*/
        modelAndView.addObject("passenger", passengerService.getById(passengerID));
        return modelAndView;
    }

    //edit passenger method
    //with POST the data is transferred
    //"redirect:/" is for redirectinf to the "/" address
    @RequestMapping(value = "/editPassenger", method = RequestMethod.POST)
    public ModelAndView editPassengerPage(@ModelAttribute("passenger") Passenger passenger) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        passengerService.edit(passenger);
        return modelAndView;
    }

    //method to add new passenger
    //jsp looks same as edit


}






