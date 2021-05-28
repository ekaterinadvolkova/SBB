package com.javaschool.ev.controller;

import com.javaschool.ev.domain.Train;
import com.javaschool.ev.dto.TimetableItemDTO;
import com.javaschool.ev.dto.TrainDTO;
import com.javaschool.ev.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
public class TrainController extends HttpServlet {

    private TrainService trainService;

    @Autowired
    public void setTrainService(TrainService trainService) {
        this.trainService = trainService;
    }

    @RequestMapping(value = "staff/trains/", method = RequestMethod.GET)
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
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editTrain");
        modelAndView.addObject("train", trainService.getById(trainID));
        return modelAndView;
    }

    @RequestMapping(value = "staff/trains/edit", method = RequestMethod.POST)
    public ModelAndView editTrainPage(@ModelAttribute("train") Train train) {
        ModelAndView modelAndView = new ModelAndView();
        trainService.edit(train);
        modelAndView.setViewName("redirect:/staff/trains/");
        return modelAndView;
    }

    @RequestMapping(value = "/staff/trains/add", method = RequestMethod.GET)
    public ModelAndView addTrain(Model m) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addTrain");
        m.addAttribute("trainDTO", new TrainDTO());
        m.addAttribute("timeTableItemDTO", new TimetableItemDTO());
        return modelAndView;
    }

    @RequestMapping(value = "/staff/trains/add", method = RequestMethod.POST)
    public ModelAndView addTrain(@ModelAttribute TrainDTO trainDTO) {
        ModelAndView modelAndView = new ModelAndView();
//        if (trainService.checkTrain(train.getNumber())) {
//        Date departureDate = new SimpleDateFormat("dd-MM-yyyy").parse();

        modelAndView.setViewName("redirect:/staff/trains/");
        trainService.add(trainDTO);
//        } else {
//            modelAndView.addObject("message", "part with title \"" + train.getNumber() + "\" already exists");
//            modelAndView.setViewName("redirect:/staff/trains/");
//        }
        return modelAndView;
    }

    @RequestMapping(value = "/staff/trains/delete/{trainID}", method = RequestMethod.GET)
    public ModelAndView deleteTrain(@PathVariable("trainID") int trainID) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/staff/trains/");
        Train train = trainService.getById(trainID);
        trainService.delete(train);
        return modelAndView;
    }
}
