package org.liftoff.vacationplanit.controllers;

import org.liftoff.vacationplanit.models.Trip;
import org.liftoff.vacationplanit.models.TripData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
@RequestMapping("")
public class MainController {


    //handler to display the index page
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("trips", TripData.getAll());
        model.addAttribute("title", "Vacation Plan-it");
        return "index";
    }

    //handler to display the add form
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddTripForm(Model model) {
        model.addAttribute("title", "Add Trip");
        return "add";
    }

    //handler to process the add form
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTripForm(@ModelAttribute Trip newTrip) {
        TripData.add(newTrip);
        return "redirect:";
    }

    //handler to display the remove form
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveTripForm(Model model) {
        model.addAttribute("trips", TripData.getAll());
        model.addAttribute("title", "Remove Trip");
        return "remove";
    }

    //handler to process the remove form
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveTripForm(@RequestParam int[] tripIds) {

       for (int tripId : tripIds) {
           TripData.remove(tripId);
       }
    return "redirect:";

    }

}
