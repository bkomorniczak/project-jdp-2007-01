package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);

    @Override
    Optional<Product> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}
