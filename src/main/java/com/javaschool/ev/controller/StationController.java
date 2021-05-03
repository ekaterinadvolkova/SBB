package com.javaschool.ev.controller;


import com.javaschool.ev.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
@RequestMapping("/station")
public class StationController {

    @Autowired
    private StationService StationService;
}
