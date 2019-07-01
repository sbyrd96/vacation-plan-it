package com.liftoff.vacationplanit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {

    static ArrayList<String> vacations = new ArrayList<>();


    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("vacations", vacations);
        model.addAttribute("title", "Vacation Plan-it");
        return "index";
    }

    //handler to display the add form
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddVacationForm(Model model) {
        model.addAttribute("title", "Add Trip");
        return "add";
    }

    //handler to process the add form
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddVacationForm(@RequestParam String vacationName) {
        vacations.add(vacationName);
        return "redirect:";
    }

}
