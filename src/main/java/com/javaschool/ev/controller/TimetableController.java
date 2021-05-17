package com.javaschool.ev.controller;

import com.javaschool.ev.domain.Timetable;
import com.javaschool.ev.service.api.TimetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
@RequestMapping("/staff/timetables")
public class TimetableController {


    private TimetableService timetableService;
    @Autowired
    public void setTimetableService (TimetableService timetableService){
        this.timetableService=timetableService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addTimetable() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addTimetable");
        return modelAndView;
    }

    @RequestMapping (value ="/add", method = RequestMethod.POST)
    public String addTimetable(@ModelAttribute("timetableItem") Timetable timetableItem) {
        timetableService.createNewTimetableItem(timetableItem);
        return "redirect:/staff";
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView getAllTimetableItems() {
        List<Timetable> timetableItems = timetableService.getAllTimetableItems();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("timetable");
        modelAndView.addObject("timetable", timetableItems);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{timetableID}}", method = RequestMethod.GET)
    public ModelAndView deleteTimetableItem(@PathVariable("timetableID") int timetableID) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Timetable timetableItem = timetableService.getById(timetableID);
        timetableService.deleteTimetableItem(timetableID);
        return modelAndView;
    }



}
