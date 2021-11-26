package ru.job4j.forum.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.AuthorityService;
import ru.job4j.forum.service.UserService;

@Controller
public class RegControl {

    private final PasswordEncoder encoder;

    private final UserService userService;

    private final AuthorityService authService;

    public RegControl(PasswordEncoder encoder, UserService userService, AuthorityService authService) {
        this.encoder = encoder;
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
    public String save(@ModelAttribute User user, Model model) {
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("errorMessage", "Данная почта уже используется");
            return "reg";
        }
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authService.findByAuthority("ROLE_USER").get());
        userService.save(user);
        return "redirect:/login";
    }
}
