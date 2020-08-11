package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderEntityTestSuite {

    @Autowired
    private OrderRepository orderRepository;
    private Order order1 = new Order();
    private Order order2 = new Order();

    @Test
    public void findAllOrderTest() {
        //Given
        orderRepository.save(order1);
        orderRepository.save(order2);
        //When
        //Then
        Assert.assertEquals(2, orderRepository.findAll().size());
        //CleanUp
        orderRepository.deleteAll();
    }

    @Test
    public void deleteAllOrderTest() {
        //Given
        orderRepository.save(order1);
        orderRepository.save(order2);
        //When
        orderRepository.deleteAll();
        //Then
        Assert.assertEquals(0, orderRepository.findAll().size());
    }

}
