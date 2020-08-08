package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository <Cart, Long> {

    @Override
    Cart save(Cart cart);

    @Override
    Optional<Cart> findById(Long id);
}
