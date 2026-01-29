package org.silvachristian.loginappspring.controller;

import org.silvachristian.loginappspring.entity.User;
import org.silvachristian.loginappspring.service.LoginService;
import org.springframework.security.authentication.jaas.LoginExceptionResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoginController {

    private LoginService loginservice;

    LoginController(LoginService loginService) {
        this.loginservice = loginService;
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/signup")
    public String registerPage(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String registerPage( @ModelAttribute("user") User user, RequestBody body){
        LoginService.registerUser(user);
        return "login";
    }




}


