package com.javaschool.ev.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcomePage");
        return modelAndView;
    }

    @RequestMapping(value = "staff/", method = RequestMethod.GET)
    public ModelAndView staffPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("staffPage");
        return modelAndView;
    }
}
