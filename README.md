🔐 Secure User Authentication System

A login and registration application built with Spring Boot 3 and Spring Security. This project demonstrates for user management, password hashing, persistent storage in PostgreSQL, and a responsive frontend.
🌟 Key Features

    Secure Registration: Users can create accounts with real-time validation.

    Password Hashing: Uses BCrypt to ensure user passwords are never stored in plain text.

    Persistent Storage: User credentials and profiles are managed in PostgreSQL.

    Flash Attributes: Provides user feedback (like "Login successful" or "Invalid credentials") using Spring MVC's redirect attributes.

    Password Change: Enables the user to update/change the password.

🛠️ Tech Stack

    Backend: Java 17+, Spring Boot 3.x, Spring Security.

    Frontend: Thymeleaf, Bootstrap 5

    Database: PostgreSQL.

    ORM: Spring Data JPA.

🧱 Project Architecture

The application is structured to separate concerns, with a focus on security:

    SecurityLogin: Configures the SecurityFilterChain, defining which pages are public (like /register) and which are protected.

    LoginService: Handles the business logic for encoding passwords and checking for duplicate usernames/emails.

    User: An implementation of UserDetails to bridge your database entity with Spring Security's internal system.

    Repository: Uses Spring Data JPA to interact with the PostgreSQL users table.

🛡️ Security Implementation

Instead of hardcoding credentials, this app leverages:

    BCryptPasswordEncoder: A strong hashing function that includes a "salt" to protect against rainbow table attacks.

    CSRF Protection: Enabled by default to prevent Cross-Site Request Forgery.

    Session Management: Securely tracks users as they navigate between protected pages.
