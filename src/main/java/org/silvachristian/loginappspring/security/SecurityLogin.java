package org.silvachristian.loginappspring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityLogin {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // 1. "Permit All" for your public pages and assets
                        .requestMatchers("/signup", "/dashboard", "/login", "/css/**", "/js/**").permitAll()
                        // 2. Everything else requires the user to be logged in
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        // 3. Tell Spring where YOUR login page i
                        .loginPage("/login")
                        // 4. Send the user here after successful login
                        .defaultSuccessUrl("/dashboard", true)
                        // 5. Explicitly allow everyone to see the login page (prevents redirect loops)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}