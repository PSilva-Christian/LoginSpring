package org.silvachristian.loginappspring.repository;

import org.jspecify.annotations.NonNull;
import org.silvachristian.loginappspring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(@NonNull String username);

    boolean existsByUsername(@NonNull String username);
}
