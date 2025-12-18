import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

package com.example.demo.repository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}


