package ru.job4j.forum.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class IndexControl {

    private final PostService postService;
    
    private final UserService userService;

    public IndexControl(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model, HttpServletRequest req) {
        req.getSession().setAttribute("curuser", new User());
        Optional<User> user =  userService.findByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName()
        );
        user.ifPresent(value -> req.getSession().setAttribute("curuser", value));
        model.addAttribute("posts", postService.getAll());
        return "index";
    }
}