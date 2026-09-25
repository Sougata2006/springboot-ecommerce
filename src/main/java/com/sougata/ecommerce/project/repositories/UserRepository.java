package com.sougata.ecommerce.project.repositories;

import com.sougata.ecommerce.project.model.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);


    boolean existsByUserName(String username);

    boolean existsByEmail(@Email String email);
}
