package org.silvachristian.loginappspring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.jspecify.annotations.NonNull;

@Setter
@Getter
@Entity
@Table(name = "postgres")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String email;
    @NonNull
    private String username;
    @NonNull
    private String password;

}
