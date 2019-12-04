package com.launchcode.adrienne.FinalProjectTest.controllers;

import com.launchcode.adrienne.FinalProjectTest.models.User;
import com.launchcode.adrienne.FinalProjectTest.models.data.PostDao;
import com.launchcode.adrienne.FinalProjectTest.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by LaunchCode
 */
public abstract class MainController {
    @Autowired
    protected PostDao postDao;

    @Autowired
    protected UserDao userDao;


    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findById(userId).get();
    }

    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getUid());
    }

    @ModelAttribute("userId")
    public Integer getUserIdFromSession(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(userSessionKey);
    }

}