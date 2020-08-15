package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {

    @Override
    List<User> findAll();

    @Override
    void deleteById(Long userId);

    @Override
    Optional<User> findById(Long userId);

    @Override
    User save(User user);

}
