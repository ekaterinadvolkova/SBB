package com.javaschool.ev.controller;

import com.javaschool.ev.domain.Station;
import com.javaschool.ev.service.api.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class StationController {

    private StationService stationService;

    @Autowired
    public void setStationService(StationService stationService) {
        this.stationService = stationService;
    }


    @RequestMapping(value = "/staff/stations/", method = RequestMethod.GET)
    public ModelAndView allStations() {
        List<Station> stations = stationService.allStations();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("stations");
        modelAndView.addObject("stationList", stations);
        return modelAndView;
    }

    @RequestMapping(value = "/staff/stations/edit", method = RequestMethod.GET)
    public ModelAndView editStation() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editStation");
        return modelAndView;
    }

    @RequestMapping(value = "/staff/stations/edit/{stationID}", method = RequestMethod.GET)
    public ModelAndView editStation(@PathVariable("stationID") int stationID) {
        Station station = stationService.getById(stationID);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editStation");
        modelAndView.addObject("station", station);
        modelAndView.addObject("station", stationService.getById(stationID));
        return modelAndView;
    }

    @RequestMapping(value = "staff/stations/edit", method = RequestMethod.POST)
    public ModelAndView editStationPage(@ModelAttribute("station") Station station) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        stationService.edit(station);
        return modelAndView;
    }

    @RequestMapping(value = "staff/stations/add", method = RequestMethod.GET)
    public ModelAndView addStation() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editStation");
        return modelAndView;
    }

    @RequestMapping(value = "staff/stations/add", method = RequestMethod.POST)
    public ModelAndView addStation(@ModelAttribute("station") Station station) {
        ModelAndView modelAndView = new ModelAndView();

        if (stationService.checkStation(station.getName())) {
            modelAndView.setViewName("redirect:/staff/");
            stationService.add(station);
        } else {
            modelAndView.addObject("message", "part with title \"" + station.getName() + "\" already exists");
            modelAndView.setViewName("redirect:/staff/");
        }
        return modelAndView;
    }

    @RequestMapping(value="/staff/stations/delete/{stationID}", method = RequestMethod.GET)
    public ModelAndView deleteStation(@PathVariable("stationID") int stationID) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/staff/");
        Station station = stationService.getById(stationID);
        stationService.delete(station);
        return modelAndView;
    }
}



