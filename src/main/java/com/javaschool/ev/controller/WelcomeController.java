package com.javaschool.ev.controller;

import com.javaschool.ev.domain.Train;
import com.javaschool.ev.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class WelcomeController {

    private TrainService trainService;
    @Autowired
    public void setTrainService (TrainService trainService){
        this.trainService=trainService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcomePage");

        List<Train> trains = trainService.allTrains();
        modelAndView.addObject("trainList", trains);

        return modelAndView;
    }

    @RequestMapping(value = "staff/", method = RequestMethod.GET)
    public ModelAndView staffPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("staffPage");
        return modelAndView;
    }


}
