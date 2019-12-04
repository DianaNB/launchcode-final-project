package com.launchcode.adrienne.FinalProjectTest.controllers;


import com.launchcode.adrienne.FinalProjectTest.models.Post;
import com.launchcode.adrienne.FinalProjectTest.models.data.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.persistence.ManyToMany;
import javax.validation.Valid;


@Controller
@RequestMapping(value="posts")
public class PostController extends MainController {


//view all posts
    @RequestMapping(value="list")
    public String list(Model model) {
        model.addAttribute("post",postDao.findAll());
        model.addAttribute("heading","All Posts");
        return "posts/list";
    }

    @RequestMapping(value = "create-post", method = RequestMethod.GET)
    public String displayAddPost(Model model) {
        model.addAttribute(new Post());
        model.addAttribute("heading", "Add New Post");
        return "posts/create-post";
    }

    @RequestMapping(value="create-post",method = RequestMethod.POST)
    public String addPost(Model model, @ModelAttribute @Valid Post newPost, BindingResult bindingResult,
                          Errors errors) {
        if (bindingResult.hasErrors()) {
            System.out.println("ERROR in post Form");
        }

        if (errors.hasErrors()) {
            model.addAttribute("heading", "Add New Post");
            return "posts/create-post";
        }
        postDao.save(newPost);
        return "redirect:view/" + newPost.getId();
    }

//view specific post
    @RequestMapping(value = "view/{postId}", method = RequestMethod.GET)
    public String viewPost(Model model, @PathVariable int postId) {
        Post post = postDao.findById(postId).get();
        model.addAttribute("post", post);
        model.addAttribute("postId", post.getId());
        return "posts/view";
    }


}