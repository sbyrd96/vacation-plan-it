package org.liftoff.vacationplanit.controllers;

import org.liftoff.vacationplanit.models.Trip;
import org.liftoff.vacationplanit.models.TripType;
import org.liftoff.vacationplanit.models.data.TripDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping("")
public class MainController {

    @Autowired
    private TripDao tripDao;

    //handler to display the index page
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("trips", tripDao.findAll());
        model.addAttribute("title", "Vacation Plan-it");
        return "index";
    }

    //handler to display the add form
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddTripForm(Model model) {
        model.addAttribute("title", "Add Trip");
        model.addAttribute(new Trip());
        model.addAttribute("tripTypes", TripType.values());
        return "add";
    }

    //handler to process the add form
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTripForm(@ModelAttribute @Valid Trip newTrip,
                                     Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Trip");
            return "add";
        }

        tripDao.save(newTrip);
        return "redirect:";
    }

    //handler to display the remove form
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveTripForm(Model model) {
        model.addAttribute("trips", tripDao.findAll());
        model.addAttribute("title", "Remove Trip");
        return "remove";
    }

    //handler to process the remove form
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveTripForm(@RequestParam int[] tripIds) {

       for (int tripId : tripIds) {
           tripDao.delete(tripId);
       }
    return "redirect:";

    }

}
