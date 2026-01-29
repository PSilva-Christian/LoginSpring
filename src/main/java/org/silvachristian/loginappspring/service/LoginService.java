package org.silvachristian.loginappspring.service;

import org.silvachristian.loginappspring.entity.User;
import org.silvachristian.loginappspring.repository.LoginRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class LoginService {
    private static LoginRepository loginrepository;

    public LoginService(LoginRepository loginRepository) {
        LoginService.loginrepository = loginRepository;
    }


    public static void registerUser(User postUser){
        User newUser = new User();
        newUser.setUsername(postUser.getUsername());
        newUser.setEmail(postUser.getEmail());
        newUser.setPassword(postUser.getPassword());
        loginrepository.save(newUser);

    }
}