package com.kodilla.ecommercee.dao;

import com.kodilla.ecommercee.domain.ProductItem;
import com.kodilla.ecommercee.repository.ProductItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductItemTestSuite {
    @Autowired
    private ProductItemRepository productItemRepository;

    @Test
    public void testSaveProductItem() {
        //Given
        ProductItem productItem = new ProductItem();

        //When
        productItemRepository.save(productItem);

        //Then
        Long id = productItem.getId();
        Optional<ProductItem> readProductItem = productItemRepository.findById(id);
        assertTrue(readProductItem.isPresent());

        //CleanUp
        productItemRepository.deleteAll();

    }
}
