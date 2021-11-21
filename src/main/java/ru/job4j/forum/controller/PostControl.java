package ru.job4j.forum.controller;

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
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            Optional<User> userOptional = userService.findByUsername(user.getUsername());
            userOptional.ifPresent(post::setUser);
            postService.save(post);
        }
        return "redirect:/index";
    }

    @GetMapping("/load")
    public String updateLoad(@RequestParam("id") int id, Model model) {
        model.addAttribute("post", postService.findById(id).get());
        return "/post/edit";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") int id, @ModelAttribute Post post) {
        Optional<Post> postFromMem = postService.findById(id);
        if (postFromMem.isPresent()) {
            postFromMem.get().setDescription(post.getDescription());
            postFromMem.get().setName(post.getName());
        }
        return "redirect:/post?id=" + id;
    }

    @GetMapping("/post")
    public String show(@RequestParam("id") int id, Model model, HttpServletRequest req) {
        model.addAttribute("post", postService.findById(id).get());
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            model.addAttribute("user", userService.findByUsername(user.getUsername()).get());
        }
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
