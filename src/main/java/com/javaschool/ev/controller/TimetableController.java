package com.javaschool.ev.controller;

import com.javaschool.ev.domain.Timetable;
import com.javaschool.ev.service.api.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class TimetableController {


    private TimetableService timetableService;

    @Autowired
    public void setTimetableService(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @RequestMapping(value = "timetables/", method = RequestMethod.GET)
    public ModelAndView getAllTimetableItems() {
        List<Timetable> timetableItems = timetableService.getAllTimetableItems();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("timetable");
        modelAndView.addObject("timetableList", timetableItems);
        return modelAndView;
    }

//    @RequestMapping(value = "staff/timetables/add", method = RequestMethod.GET)
//    public ModelAndView addTimetable() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("addTimetable");
//        return modelAndView;
//    }

    @RequestMapping(value = "timetables/add", method = RequestMethod.POST)
    public String addTimetable(@ModelAttribute("timetableItem") Timetable timetableItem) {
        timetableService.createNewTimetableItem(timetableItem);
        return "redirect:/staff";
    }

    @RequestMapping(value = "timetables/delete/{timetableID}}", method = RequestMethod.GET)
    public ModelAndView deleteTimetableItem(@PathVariable("timetableID") int timetableID) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Timetable timetableItem = timetableService.getById(timetableID);
        timetableService.deleteTimetableItem(timetableItem);
        return modelAndView;
    }


    @RequestMapping(value = "edit/{timetableID}", method = RequestMethod.GET)
    public ModelAndView editTimetable(@PathVariable("timetableID") int timetableID) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editTimetable");
        modelAndView.addObject("timetable", timetableService.getById(timetableID));
        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelAndView editTimetablePage(@ModelAttribute("timetable") Timetable timetableItem) {
        ModelAndView modelAndView = new ModelAndView();
        timetableService.editTimetableItem(timetableItem);
        modelAndView.setViewName("redirect:timetables");
        return modelAndView;
    }

}
