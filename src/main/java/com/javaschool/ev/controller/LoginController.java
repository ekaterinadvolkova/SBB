package com.javaschool.ev.controller;

import com.javaschool.ev.domain.Login;
import com.javaschool.ev.domain.User;
import com.javaschool.ev.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("login") Login login) {
        ModelAndView mav = null;

        User user = userService.validateUser(login);

        if (null != user) {
            mav = new ModelAndView("welcomePage");
            mav.addObject("userId", user.getId());

            mav.setViewName("redirect:/welcomePage/");
        } else {
            mav = new ModelAndView("login");
            mav.addObject("message", "You could not be logged in. Please check your details.");
        }

        return mav;
    }

}

