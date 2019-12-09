package com.launchcode.adrienne.FinalProjectTest.controllers;
import com.launchcode.adrienne.FinalProjectTest.models.User;
import com.launchcode.adrienne.FinalProjectTest.models.forms.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class LoginController extends MainController {

@RequestMapping(value = "login", method = RequestMethod.GET)
public String login(Model model) {
        model.addAttribute(new Login());
        model.addAttribute("heading", "Log In");
        return "user/login";
        }

@RequestMapping(value = "/login", method = RequestMethod.POST)
public String login(@ModelAttribute @Valid Login form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
        return "user/login";
        }

        User user = userDao.findByUsername(form.getUsername());
        String password = form.getPassword();

        if (user == null) {
        errors.rejectValue("username", "user.invalid", "The given username does not exist");
        return "user/login";
        }

        if (!user.isMatchingPassword(password)) {
        errors.rejectValue("password", "password.invalid", "Invalid password");
        return "user/login";
        }

        setUserInSession(request.getSession(), user);

        return "redirect:/";
        }

@RequestMapping(value = "/", method = RequestMethod.GET)
public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/";
        }

        }