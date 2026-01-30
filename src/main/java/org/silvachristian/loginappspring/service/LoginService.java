package org.silvachristian.loginappspring.service;

import org.silvachristian.loginappspring.entity.User;
import org.silvachristian.loginappspring.repository.LoginRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class LoginService {
    private final LoginRepository loginrepository;
    private final PasswordEncoder passwordEncoder;

    public LoginService(LoginRepository loginRepository, PasswordEncoder passwordEncoder) {
        this.loginrepository = loginRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean registerUser(User postUser){
        if (!loginrepository.existsByUsername(postUser.getUsername())) {
            User newUser = new User();
            newUser.setUsername(postUser.getUsername());
            newUser.setEmail(postUser.getEmail());
            newUser.setPassword(Objects.requireNonNull(passwordEncoder.encode(postUser.getPassword())));
            loginrepository.save(newUser);
            return true;
        }
        else{
            return false;
        }
    }

    public User getUserCredentials(String username){
        Optional<User> usernameResult = loginrepository.findByUsername(username);
        return usernameResult.orElseGet(() -> null);
    }
}

