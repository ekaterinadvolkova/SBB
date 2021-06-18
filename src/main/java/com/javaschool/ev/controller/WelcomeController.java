package com.javaschool.ev.controller;

import com.javaschool.ev.domain.Station;
import com.javaschool.ev.domain.Train;
import com.javaschool.ev.dto.TrainDTO;
import com.javaschool.ev.service.api.StationService;
import com.javaschool.ev.service.api.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class WelcomeController {

    private StationService stationService;

    @Autowired
    public void setStationService(StationService stationService) {
        this.stationService = stationService;
    }

    private TrainService trainService;

    @Autowired
    public void setTrainService(TrainService trainService) {
        this.trainService = trainService;
    }


    @RequestMapping(value = "/welcomePage", method = RequestMethod.GET)
    public ModelAndView welcomePage(@RequestParam("firstname") String firstname) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcomePage");

        List<TrainDTO> trains = trainService.allTrains();
        modelAndView.addObject("trainList", trains);

        return modelAndView;
    }

    @RequestMapping(value = "staff/", method = RequestMethod.GET)
    public ModelAndView staffPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("staffPage");

        List<Station> stations = stationService.allStations();
        modelAndView.addObject("stationList", stations);
        return modelAndView;
    }

    @RequestMapping(value = "tickets/", method = RequestMethod.GET)
    public ModelAndView tickets() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tickets");
//        modelAndView.addObject("tickets", tickets());
        return modelAndView;
    }

}
