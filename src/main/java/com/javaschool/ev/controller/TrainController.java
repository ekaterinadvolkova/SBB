package com.javaschool.ev.controller;

import com.javaschool.ev.domain.Train;
import com.javaschool.ev.dto.TimetableItemDTO;
import com.javaschool.ev.dto.TrainDTO;
import com.javaschool.ev.service.api.StationService;
import com.javaschool.ev.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServlet;
import java.util.List;

@RestController
public class TrainController extends HttpServlet {

    @Autowired
    private TrainService trainService;
    @Autowired
    private StationService stationService;

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
    public ModelAndView addTrain(@ModelAttribute(name = "train") TrainDTO train,
                                 BindingResult bindingResult, ModelMap modelMap,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("addTrain");

        if (train.getTimetable().size() == 0) {
            TrainDTO trainDTO = new TrainDTO();
            trainDTO.setStationNames(stationService.getAvailableStationNames());
            modelAndView.addObject("train", trainDTO);
        } else {
            train.setStationNames(stationService.getAvailableStationNames());
            modelAndView.addObject("train", train);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/staff/trains/add", method = RequestMethod.POST, params = "addTimetableItem")
    public ModelAndView addTimetableItem(@ModelAttribute(name = "train") TrainDTO train,
                                         BindingResult bindingResult, ModelMap modelMap,
                                         RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }

        ModelAndView modelAndView = new ModelAndView("addTrain");

        train.getTimetable().add(new TimetableItemDTO());
        redirectAttributes.addFlashAttribute("train", train);
        modelAndView.setViewName("redirect:/staff/trains/add");
        return modelAndView;
    }

    @RequestMapping(value = "/staff/trains/add", method = RequestMethod.POST, params = "addTrain")
    public ModelAndView addTrain(@ModelAttribute(name = "train") TrainDTO train,
                                 BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }

        trainService.add(train);
        ModelAndView modelAndView = new ModelAndView("redirect:/staff/trains/");
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

