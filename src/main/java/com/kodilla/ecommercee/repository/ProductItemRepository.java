package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {

    @Override
    Optional<ProductItem> findById(Long id);
}
