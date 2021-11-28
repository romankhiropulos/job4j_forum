package ru.job4j.forum.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class PostControl {

    private final PostService postService;

    private final UserService userService;

    public PostControl(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String create() {
        return "/post/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Post post, HttpServletRequest req) {
        Optional<User> user =  userService.findByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName()
        );
        if (user.isPresent()) {
            post.setUser(user.get());
            postService.save(post);
        }
        return "redirect:/index";
    }

    @GetMapping("/load")
    public String updateLoad(@RequestParam("id") int id, Model model) {
        Optional<Post> postOptional = postService.findById(id);
        if (postOptional.isEmpty()) {
            return "redirect:/index";
        }
        model.addAttribute("post", postOptional.get());
        return "/post/edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") int id, @ModelAttribute Post post) {
        post.setId(id);
        postService.save(post);
        return "redirect:/post?id=" + id;
    }

    @GetMapping("/post")
    public String show(@RequestParam("id") int id, Model model, HttpServletRequest req) {
        Optional<Post> postOptional = postService.findById(id);
        if (postOptional.isEmpty()) {
            return "redirect:/index";
        }
        model.addAttribute("post", postOptional.get());
        return "/post/post";
    }

    @GetMapping("delete")
    public String delete(@RequestParam("id") int id) {
        if (postService.findById(id).isEmpty()) {
            return "redirect:/index";
        }
        postService.delete(postService.findById(id).get());
        return "redirect:/index";
    }
}
