package org.silvachristian.loginappspring.service;

import org.jspecify.annotations.NonNull;
import org.silvachristian.loginappspring.entity.User;
import org.silvachristian.loginappspring.repository.LoginRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final LoginRepository loginRepository;

    MyUserDetailsService(LoginRepository loginrepository){
        this.loginRepository = loginrepository;
    }

    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        User user = loginRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // This returns the UserDetails object Spring Security needs
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword()) // This must be the encoded password from DB
                .authorities("USER")
                .build();
    }
}
