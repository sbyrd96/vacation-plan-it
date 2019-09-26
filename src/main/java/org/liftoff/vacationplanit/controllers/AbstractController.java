package org.liftoff.vacationplanit.controllers;

import org.liftoff.vacationplanit.models.User;
import org.liftoff.vacationplanit.models.data.CategoryDao;
import org.liftoff.vacationplanit.models.data.PlanDao;
import org.liftoff.vacationplanit.models.data.TripDao;
import org.liftoff.vacationplanit.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class AbstractController {

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected TripDao tripDao;

    @Autowired
    protected CategoryDao categoryDao;

    @Autowired
    protected PlanDao planDao;

    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findOne(userId);
    }

    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getUid());
    }

    @ModelAttribute("userId")
    public Integer getUserIdFromSession(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(userSessionKey);
    }

}
