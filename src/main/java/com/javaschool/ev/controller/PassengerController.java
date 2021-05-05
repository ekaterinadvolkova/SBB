package com.javaschool.ev.controller;

import com.javaschool.ev.domain.Passenger;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PassengerController {

        private static Passenger passenger;

        static {
            passenger = new Passenger();
            passenger.setFirstName("Kate");
            passenger.setLastName("Middleton");
            passenger.setBirthDate("20-12-1997");
        }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allPassengers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("passengers");
        modelAndView.addObject("passenger", passenger);
        return modelAndView;
    }

    @RequestMapping(value = "/editPassenger", method = RequestMethod.GET)
    public ModelAndView editPassenger() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPassenger");
        return modelAndView;
    }

}






