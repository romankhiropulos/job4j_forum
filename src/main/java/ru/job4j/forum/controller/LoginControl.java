package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class LoginControl {

    private final UserService userService;

    public LoginControl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String reg() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model,
                            HttpServletRequest req) {

        String errorMessage = null;
        if (logout != null) {
            errorMessage = "You have been successfully logged out !!";
            model.addAttribute("error", errorMessage);
            return "login";
        }
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Optional<User> userOptional = userService.findByUsernameAndPassword(username, password);
        if (userOptional.isPresent()) {
            HttpSession sc = req.getSession();
            sc.setAttribute("user", userOptional.get());
        } else {
            errorMessage = "Username or Password is incorrect !!";
            model.addAttribute("error", errorMessage);
            return "login";
        }
        return "redirect:/index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {

        return "redirect:/login?logout=true";
    }
}
