package org.silvachristian.loginappspring.controller;

import org.silvachristian.loginappspring.entity.User;
import org.silvachristian.loginappspring.repository.LoginRepository;
import org.silvachristian.loginappspring.service.LoginService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final LoginService loginService;
    private final LoginRepository loginRepository;

    LoginController(LoginService loginService, LoginRepository loginRepository) {
        this.loginService = loginService;
        this.loginRepository = loginRepository;
    }

    @RequestMapping("/login")
    public String showLoginPage(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/signup")
    public String showRegisterPage(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String sendCredentialsRegisterPage(@ModelAttribute("user") User user){

        if (loginService.registerUser(user)) {
            return "redirect:/login";
        }
        return "signup";
    }

    @GetMapping("/dashboard")
    public String showDashBoardUser(@AuthenticationPrincipal UserDetails currentUser, Model model){
        User userResultDashboard = loginService.getUserCredentials(currentUser.getUsername());
        model.addAttribute("username", userResultDashboard.getUsername());
        model.addAttribute("email", userResultDashboard.getEmail());

        return "dashboard";
    }




}


