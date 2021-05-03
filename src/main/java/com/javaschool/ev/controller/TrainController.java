package com.javaschool.ev.controller;

import com.javaschool.ev.domain.Train;
import com.javaschool.ev.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@EnableWebMvc
@RequestMapping("/train")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView validateTrain() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("trainFromServer", new Train());
        modelAndView.setViewName("trains_add");
        return modelAndView;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public @ResponseBody
    String checkTrain(@ModelAttribute("trainFromServer") Train train) {
        if (new Train().getNumber() == train.getNumber()) {
            return "Train " + train.getNumber()+ " added";
        }
        return "Train was not added. Try again" ;
    }

}
