package com.javaschool.ev.controller;

import com.javaschool.ev.dao.api.UserDao;
import com.javaschool.ev.dao.impl.UserDAOImpl;
import com.javaschool.ev.domain.Station;
import com.javaschool.ev.dto.TicketDTO;
import com.javaschool.ev.dto.TrainDTO;
import com.javaschool.ev.dto.WelcomeDTO;
import com.javaschool.ev.mapper.UserMapper;
import com.javaschool.ev.service.api.StationService;
import com.javaschool.ev.service.api.TrainService;
import com.javaschool.ev.service.api.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class WelcomeController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(WelcomeController.class);

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

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;


    private UserDao userDao = new UserDAOImpl();



    @RequestMapping(value = "/welcomePage", method = RequestMethod.GET)
    public ModelAndView welcomePage(@ModelAttribute(name = "welcome") WelcomeDTO welcomeDTO,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("error");
        }

        ModelAndView modelAndView = new ModelAndView("welcomePage");

        welcomeDTO.setStationNames(stationService.getAvailableStationNames(true));
        welcomeDTO.setTrains(trainService.allTrains(welcomeDTO.getSelectedStation()));

        log.info("metod GET, welcome=" + welcomeDTO.toString());
        modelAndView.addObject("welcome", welcomeDTO);

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

    @RequestMapping(value = "tickets/{userId}/{trainId}", method = RequestMethod.GET)
    public ModelAndView tickets(@PathVariable("userId") int userId, @PathVariable("trainId") int trainId) {
        ModelAndView modelAndView = new ModelAndView();

        List<String> errors = trainService.addTicket(trainId, userId);
        if (errors.isEmpty()) {
            TicketDTO ticketDTO = new TicketDTO();
            ticketDTO.setUser(userMapper.convertToDto(userService.getById(userId)));
            ticketDTO.setTrain(trainService.getById(trainId));

            //reduce amount of seats


            modelAndView.addObject("ticket", ticketDTO);
            modelAndView.setViewName("tickets");


        } else {

            //show error
        }


//        modelAndView.addObject("tickets", tickets);
        return modelAndView;
    }

}
