package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.memory.AuthorityMemoryRep;
import ru.job4j.forum.service.UserService;

@Controller
public class RegControl {

    private final UserService userService;

    private final AuthorityMemoryRep authService;

    public RegControl(UserService userService, AuthorityMemoryRep authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, Model model) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("error", "Данная почта уже используется");
            return "reg";
        }
        user.setEnabled(true);
        user.setAuthority(authService.findByAuthority("ROLE_USER").get());
        userService.save(user);
        return "redirect:/login";
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }
}
