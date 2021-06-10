package com.javaschool.ev.controller;

import com.javaschool.ev.domain.Passenger;
import com.javaschool.ev.service.api.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PassengerController {

    /*
    add service to call its methods later
    @Autowired annotation not to create new objects of the class
     */
    private PassengerService passengerService;

    @Autowired
    public void setPassengerService(PassengerService passengerService) {
        this.passengerService = passengerService;
    }


    /*
    all passengers list in a table
    value="/" is added again to work later with redirect
     */
    @RequestMapping(value = "staff/passengers/", method = RequestMethod.GET)
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
    @RequestMapping(value = "/staff/passengers/edit", method = RequestMethod.GET)
    public ModelAndView editPassenger() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPassenger");
        return modelAndView;
    }

    /*
    get to the EditPassenger Page with ID
     */
    @RequestMapping(value = "/staff/passengers/edit/{passengerID}", method = RequestMethod.GET)
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
    @RequestMapping(value = "staff/passengers/edit", method = RequestMethod.POST)
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
    @RequestMapping(value = "staff/passengers/add", method = RequestMethod.GET)
    public ModelAndView addPassenger() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPassenger");
        return modelAndView;
    }

    /*

    add feature of checking if the passenger exists
     */
    @RequestMapping(value = "staff/passengers/add", method = RequestMethod.POST)
    public ModelAndView addPassenger(@ModelAttribute("passenger") Passenger passenger, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }

        if (passengerService.checkPassenger(passenger.getFirstName(), passenger.getLastName(), passenger.getBirthDate())) {
            modelAndView.setViewName("redirect:/staff/passengers/");
            passengerService.add(passenger);
        } else {
            modelAndView.addObject("message", "part with title \"" + passenger.getFirstName()
                    + passenger.getLastName() + passenger.getBirthDate() + "\" already exists");
            modelAndView.setViewName("redirect:/staff/passengers/");
        }
        return modelAndView;
    }

    /*
    delete passenger from the list
    "/" at the beginning is deleted
     */
    @RequestMapping(value = "/staff/passengers/delete/{passengerID}", method = RequestMethod.GET)
    public ModelAndView deletePassenger(@PathVariable("passengerID") int passengerID) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/staff/");
        Passenger passenger = passengerService.getById(passengerID);
        passengerService.delete(passenger);
        return modelAndView;
    }
}