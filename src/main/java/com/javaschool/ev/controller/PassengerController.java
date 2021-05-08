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

    //add service to call its methods later
    private final PassengerService passengerService = new PassengerServiceImpl();

    /*
    first controller
    all passengers list in a table
    value="/" is deleted
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!passengeRR

    private static Passenger passengerr;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allPassengers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("passengers");
        modelAndView.addObject("passenger", passengerr);
        return modelAndView;
    }*/

    /*
    all passengers list in a table
    value="/" is added again to work later with redirect
     */
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView allPassengers() {
        List<Passenger> passengers = passengerService.allPassengers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("passengers");
        modelAndView.addObject("passengerList", passengers);
        return modelAndView;
    }

    /*
     get to the EditPassenger without ID
     */
    @RequestMapping(value = "/editPassenger", method = RequestMethod.GET)
    public ModelAndView editPassenger() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPassenger");
        return modelAndView;
    }
    /*
    get to the EditPassenger Page with ID
     */
    @RequestMapping(value = "/editPassenger/{passengerID}", method = RequestMethod.GET)
    public ModelAndView editPassenger(@PathVariable("passengerID") int passengerID) {
        Passenger passenger = passengerService.getById(passengerID);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPassenger");
        modelAndView.addObject("passenger", passenger);
        modelAndView.addObject("passenger", passengerService.getById(passengerID));
        return modelAndView;
    }

    /*
    edit passenger method
    with POST the data is transferred
    "redirect:/" is for redirectinf to the "/" address
    */
    @RequestMapping(value = "/editPassenger", method = RequestMethod.POST)
    public ModelAndView editPassengerPage(@ModelAttribute("passenger") Passenger passenger) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        passengerService.edit(passenger);
        return modelAndView;
    }

    /*
    method to get to the page "add new passenger"
    jsp looks same as edit --> one jsp for editing and adding the passenger
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPassenger() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPassenger");
        return modelAndView;
    }

    /*
    method of adding passenger
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addPassenger(@ModelAttribute("passenger") Passenger passenger) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        passengerService.add(passenger);
        return modelAndView;
    }
}






