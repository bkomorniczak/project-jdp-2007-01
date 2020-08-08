package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductEntityTestSuite {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testSaveProduct(){
        //Given
        Product product1 = new Product((long) 1, "name1", "desc1",1);
        Product product2 = new Product((long) 2, "name2", "desc2",2);
        Product product3 = new Product((long) 3, "name3", "desc3",3);
        Product product4 = new Product((long) 4, "name4", "desc4",4);
        Product product5 = new Product((long) 5, "name5", "desc5",5);

        //When
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);

        //Then
        List<Product> productList = productRepository.findAll();
        Assert.assertEquals(5, productList.size());

        //Cleanup
        /*productRepository.deleteById(product1.getId());
        productRepository.deleteById(product2.getId());
        productRepository.deleteById(product3.getId());
        productRepository.deleteById(product4.getId());
        productRepository.deleteById(product5.getId());*/
    }

    @Test
    public void testDeleteProduct(){
        //Given
        Product product1 = new Product((long) 1, "name1", "desc1",1);
        productRepository.save(product1);
        //When
        productRepository.deleteById(product1.getId());
        //Then
        List<Product> productList = productRepository.findAll();
        Assert.assertTrue(productList.isEmpty());
    }

    @Test
    public void testUpdateProduct(){
        //Given
        Product product1 = new Product((long) 1, "name1","desc1",1);

        //When
        productRepository.save(product1);
        product1.setName("Updated Name");
        product1.setDescription("Updated Description");
        product1.setPrice(2);
        productRepository.save(product1);
        Optional<Product> updatedProduct = productRepository.findById(1L);
        //Then
        updatedProduct.ifPresent(product -> Assert.assertEquals(product.getName(),"Updated Name"));
        //Cleanup
       // productRepository.deleteById(product1.getId());
    }

    @After
    public void cleanUp(){
        productRepository.deleteAll();
    }
}
