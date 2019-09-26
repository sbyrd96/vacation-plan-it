package org.liftoff.vacationplanit.controllers;

import org.liftoff.vacationplanit.models.Category;
import org.liftoff.vacationplanit.models.Trip;
import org.liftoff.vacationplanit.models.User;
import org.liftoff.vacationplanit.models.data.CategoryDao;
import org.liftoff.vacationplanit.models.data.TripDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("trip")
public class MainController extends AbstractController {

    //handler to display the index page
    @RequestMapping(value = "")
    public String index(Model model, HttpServletRequest request) {

        User user = getUserFromSession(request.getSession());

        model.addAttribute("trips", tripDao.findByOwner(user));
        model.addAttribute("title", "Vacation Plan-it");
        return "trip/index";
    }

    //handler to display the add form
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddTripForm(Model model) {
        model.addAttribute("title", "Add Trip");
        model.addAttribute(new Trip());
        model.addAttribute("categories", categoryDao.findAll());
        return "trip/add";
    }

    //handler to process the add form
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTripForm(@ModelAttribute @Valid Trip newTrip,
                                     Errors errors, @RequestParam int categoryId,
                                     Model model, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Trip");
            model.addAttribute("categories", categoryDao.findAll());
            return "trip/add";
        }

        User owner = getUserFromSession(request.getSession());
        newTrip.setOwner(owner);

        Category cat = categoryDao.findOne(categoryId);
        newTrip.setCategory(cat);

        tripDao.save(newTrip);

        return "redirect:";
    }

    //handler to display the remove form
    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveTripForm(Model model, HttpServletRequest request) {

        User user = getUserFromSession(request.getSession());

        model.addAttribute("trips", tripDao.findByOwner(user));
        model.addAttribute("title", "Remove Trip");
        return "trip/remove";
    }

    //handler to process the remove form
    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveTripForm(@RequestParam int[] ids) {

       for (int id : ids) {
           tripDao.delete(id);
       }
    return "redirect:";

    }

    @RequestMapping(value = "category", method = RequestMethod.GET)
    public String category(Model model, @RequestParam int uid) {

        Category cat = categoryDao.findOne(uid);
        List<Trip> trips = cat.getTrips();
        model.addAttribute("trips", trips);
        model.addAttribute("title", "Trips in Category: " + cat.getName());
        return "trip/index";

    }

}
