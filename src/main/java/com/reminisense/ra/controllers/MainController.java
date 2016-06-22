package com.reminisense.ra.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Nigs on 2016-06-07.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletRequest request, Model model) {
        Calendar calendar = new GregorianCalendar(request.getLocale());
        String currentTime = calendar.getTime().toString();
        model.addAttribute("serverTime", currentTime);
        return "index.html";
    }
}
