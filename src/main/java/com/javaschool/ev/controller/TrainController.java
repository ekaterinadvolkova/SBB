package com.javaschool.ev.controller;

import com.javaschool.ev.dto.TimetableItemDTO;
import com.javaschool.ev.dto.TrainDTO;
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

    @RequestMapping(value = "staff/trains/", method = RequestMethod.GET)
    public ModelAndView allTrains() {
        List<TrainDTO> trains = trainService.allTrains();
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

    @RequestMapping(value = "/staff/trains/add", method = RequestMethod.GET)
    public ModelAndView addTrain(@ModelAttribute(name = "train") TrainDTO train,
                                 BindingResult bindingResult, ModelMap modelMap,
                                 RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("manageTrain");

        if (train.isUpdated()) {
            modelAndView.addObject("train", train);
        } else {
            TrainDTO trainDTO = trainService.getById(-1);
            modelAndView.addObject("train", trainDTO);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/staff/trains/add", method = RequestMethod.POST, params = "addTimetableItem")
    public ModelAndView addTimetableItem(@ModelAttribute(name = "train") TrainDTO train,
                                         BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }

        ModelAndView modelAndView = new ModelAndView("manageTrain");

        train.getTimetable().add(new TimetableItemDTO());
        train.setUpdated(true);
        redirectAttributes.addFlashAttribute("train", train);
        modelAndView.setViewName("redirect:/staff/trains/add");
        return modelAndView;
    }

    @RequestMapping(value = "/staff/trains/add", method = RequestMethod.POST, params = "addTrain")
    public ModelAndView addTrain(@ModelAttribute(name = "train") TrainDTO train,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }
        // Check for errors and return back
        List<String> errors = trainService.validateTrain(train);
        if (errors.size() > 0) {
            ModelAndView modelAndView = new ModelAndView("manageTrain");
            train.setErrors(errors);
            train.setUpdated(true);
            redirectAttributes.addFlashAttribute("train", train);
            modelAndView.setViewName("redirect:/staff/trains/add");
            return modelAndView;
        }

        // No errors
        trainService.add(train);
        ModelAndView modelAndView = new ModelAndView("redirect:/staff/trains/");
        return modelAndView;
    }

    @RequestMapping(value = "/staff/trains/edit/{trainId}", method = RequestMethod.GET)
    public ModelAndView editTrain(@PathVariable("trainId") int trainId, @ModelAttribute(name = "train") TrainDTO train,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }

        ModelAndView modelAndView = new ModelAndView("manageTrain");

        if (train.isUpdated()) {
            modelAndView.addObject("train", train);
        } else {
            modelAndView.addObject("train", trainService.getById(trainId));
        }
        return modelAndView;
    }

    @RequestMapping(value = "/staff/trains/edit/{trainId}", method = RequestMethod.POST, params = "addTimetableItem")
    public ModelAndView addTimetableItem(@PathVariable("trainId") int trainId, @ModelAttribute(name = "train") TrainDTO train,
                                         BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }

        ModelAndView modelAndView = new ModelAndView("manageTrain");

        train.getTimetable().add(new TimetableItemDTO());
        train.setUpdated(true);
        train.setErrors(null);
        redirectAttributes.addFlashAttribute("train", train);
        modelAndView.setViewName("redirect:/staff/trains/edit/" + trainId);
        return modelAndView;
    }

    @RequestMapping(value = "/staff/trains/edit/{trainId}", method = RequestMethod.POST)
    public ModelAndView updateTrain(@PathVariable("trainId") int trainId, @ModelAttribute(name = "train") TrainDTO train,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }
        // Check for errors and return back
        List<String> errors = trainService.validateTrain(train);
        if (errors.size() > 0) {
            ModelAndView modelAndView = new ModelAndView("manageTrain");
            train.setErrors(errors);
            redirectAttributes.addFlashAttribute("train", train);
            modelAndView.setViewName("redirect:/staff/trains/edit/" + trainId);
            return modelAndView;
        }

        // No errors
        trainService.update(train);
        ModelAndView modelAndView = new ModelAndView("redirect:/staff/trains/");
        return modelAndView;
    }

    @RequestMapping(value = "/staff/trains/delete/{trainId}", method = RequestMethod.GET)
    public ModelAndView deleteTrain(@PathVariable("trainId") int trainId) {
        trainService.delete(trainId);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/staff/trains/");
        return modelAndView;
    }
}
