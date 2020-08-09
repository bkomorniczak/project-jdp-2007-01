package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
    @Override
    ProductItem save(ProductItem productItem);

    @Override
    Optional<ProductItem> findById(Long aLong);

}
