package com.launchcode.adrienne.FinalProjectTest.controllers;

import com.launchcode.adrienne.FinalProjectTest.models.User;
import com.launchcode.adrienne.FinalProjectTest.models.data.UserDao;
import com.launchcode.adrienne.FinalProjectTest.models.forms.Login;
import com.launchcode.adrienne.FinalProjectTest.models.forms.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class RegistrationController extends MainController {

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerDisplay(Model model) {
        model.addAttribute(new Register());
        model.addAttribute("heading", "Register");
        return "user/register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute @Valid Register form, BindingResult bindingResult,
                           Errors errors, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            System.out.println("ERROR in user Form");
        }
        if (errors.hasErrors()) {
            model.addAttribute("heading", "Register");
            return "user/register";
        }
        User existingUser = userDao.findByUsername(form.getUsername());

        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists", "A user with that username already exists");
            return "user/register";
        }

        User user = new User(form.getUsername(), form.getPassword());
        userDao.save(user);
        setUserInSession(request.getSession(), user);

        return "redirect:/";

    }


}





