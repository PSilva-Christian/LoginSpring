package org.silvachristian.loginappspring.controller;

import org.silvachristian.loginappspring.entity.User;
import org.silvachristian.loginappspring.service.LoginService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postgres")
public class LoginController {

    private LoginService loginservice;

    LoginController(LoginService loginService){
        this.loginservice = loginService;
    }
    
    @PostMapping
    List<User >create(@RequestBody User user){
        return LoginService.create(user);
    }
    
    @GetMapping
    List<User> list(){
        return LoginService.list();
    }
    
    @PutMapping
    List<User> update(@RequestBody User user){
        return LoginService.update(user);
    }

    @DeleteMapping("{id}")
    List<User> delete(@PathVariable Long id){
        return LoginService.delete(id);
    }
}

