package org.liftoff.vacationplanit.controllers;

import org.liftoff.vacationplanit.models.Plan;
import org.liftoff.vacationplanit.models.Trip;
import org.liftoff.vacationplanit.models.forms.AddPlanItemForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "plan")
public class PlanController  extends AbstractController {

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Plans");
        model.addAttribute("plans", planDao.findAll());
        return "menu/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
        public String add(Model model) {
        model.addAttribute("title", "Add Plans");
        model.addAttribute(new Plan());
        return "plan/add";
        }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Plan plan,
                      Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Plans");
            return "plan/add";
        }

        planDao.save(plan);

        return "redirect:view/" + plan.getUid();
    }

    @RequestMapping(value = "view/{planId}", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable int planId) {

        Plan plan = planDao.findOne(planId);
        model.addAttribute("plan", plan);

        return "plan/view";
    }

    @RequestMapping(value = "add-item/{planId}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int planId) {

        Plan plan = planDao.findOne(planId);

        AddPlanItemForm form = new AddPlanItemForm(
                tripDao.findAll(), plan);

        model.addAttribute("title", "Add item to plans: " + plan.getName());
        model.addAttribute("form", form);
        return "plan/add-item";
    }

    @RequestMapping(value = "add-item", method = RequestMethod.POST)
    public String addItem(Model model, @ModelAttribute @Valid
                          AddPlanItemForm form, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "plan/add-item";
        }

        Trip theTrip = tripDao.findOne(form.getTripId());
        Plan thePlan = planDao.findOne(form.getPlanId());
        thePlan.addItem(theTrip);
        planDao.save(thePlan);

        return "redirect:/plan/view/" + thePlan.getUid();
    }

}
