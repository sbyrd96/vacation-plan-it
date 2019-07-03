package org.liftoff.vacationplanit.controllers;

import org.liftoff.vacationplanit.models.Trip;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("trips")
public class MainController {

    static ArrayList<Trip> trips = new ArrayList<>();

    //handler to display the index page
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("trips", trips);
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
    public String processAddTripForm(@RequestParam String tripName,
                                     @RequestParam String tripDescription) {
        Trip newTrip = new Trip(tripName, tripDescription);
        trips.add(newTrip);
        return "redirect:";
    }

    //handler to display the remove form
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveTripForm(Model model) {
        model.addAttribute("trips", trips);
        model.addAttribute("title", "Remove Trip");
        return "remove";
    }

    //handler to process the remove form
    //@RequestMapping(value = "remove", method = RequestMethod.POST)
    //public String processRemoveTripForm(@RequestParam ArrayList<String> trip) {

    //   for (String aTrips : trip) {
     //       trips.remove(aTrips);
      //  }
        //return "redirect:";

    //}

}
