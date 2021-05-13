package com.javaschool.ev.controller;

import com.javaschool.ev.domain.Train;
import com.javaschool.ev.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class TrainController {

    private TrainService trainService;

    @Autowired
    public void setTrainService (TrainService trainService){
        this.trainService=trainService;
    }

    @RequestMapping(value="staff/trains/", method = RequestMethod.GET)
    public ModelAndView allTrains() {
        List<Train> trains = trainService.allTrains();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("trains");
        modelAndView.addObject("trainList", trains);
        return modelAndView;
    }
    @RequestMapping(value = "/staff/trains/edit", method = RequestMethod.GET)
    public ModelAndView editTrain() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editTrain");
        return modelAndView;
    }

    @RequestMapping(value = "/staff/trains/edit/{trainID}", method = RequestMethod.GET)
    public ModelAndView editTrain(@PathVariable("trainID") int trainID) {
        Train train = trainService.getById(trainID);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editTrain");
        modelAndView.addObject("train", train);
        modelAndView.addObject("train", trainService.getById(trainID));
        return modelAndView;
    }

    @RequestMapping(value = "staff/trains/edit", method = RequestMethod.POST)
    public ModelAndView editTrainPage(@ModelAttribute("train") Train train) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        trainService.edit(train);
        return modelAndView;
    }

    @RequestMapping(value = "staff/trains/add", method = RequestMethod.GET)
    public ModelAndView addTrain() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editTrain");
        return modelAndView;
    }

    @RequestMapping(value = "staff/trains/add", method = RequestMethod.POST)
    public ModelAndView addTrain(@ModelAttribute("train") Train train) {
        ModelAndView modelAndView = new ModelAndView();

        if (trainService.checkTrain(train.getNumber())) {
            modelAndView.setViewName("redirect:/staff/trains/");
            trainService.add(train);
        } else {
            modelAndView.addObject("message", "part with title \"" + train.getNumber() + "\" already exists");
            modelAndView.setViewName("redirect:/staff/trains/");
        }
        return modelAndView;
    }

    @RequestMapping(value="/staff/trains/delete/{trainID}", method = RequestMethod.GET)
    public ModelAndView deleteTrain(@PathVariable("trainID") int trainID) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/staff/trains/");
        Train train = trainService.getById(trainID);
        trainService.delete(train);
        return modelAndView;
    }
}
