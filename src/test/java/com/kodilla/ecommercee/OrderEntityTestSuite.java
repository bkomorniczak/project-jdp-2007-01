package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.OrderDto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

public class OrderEntityTestSuite {

    @Autowired
    private OrderDto orderDto;
    private OrderDto order1;
    private OrderDto order2;

    @Test
    public void getOrdersTest() {
        //Given
        List<OrderDto> orderDtos = new ArrayList<>();
        orderDtos.add(order1);
        orderDtos.add(order2);
        //When
        //Then
        Assert.assertEquals(order1, orderDtos.get(1));
    }

    @Test
    public void deleteOrderTest() {
        //Given
        List<OrderDto> orderDtos = new ArrayList<>();
        orderDtos.add(order1);
        orderDtos.add(order2);
        //When
        orderDtos.remove(1);
        //Then
        Assert.assertEquals(1, orderDtos.size());
    }

    @Test
    public void createOrderTest() {
        //Given
        List<OrderDto> orderDtos = new ArrayList<>();
        orderDtos.add(order1);
        orderDtos.add(order2);
        //When
        OrderDto order3 = new OrderDto();
        orderDtos.add(order3);
        //Then
        Assert.assertEquals(3, orderDtos.size());
    }

    @Test
    public void updateOrder() {
        //Given
        List<OrderDto> orderDtos = new ArrayList<>();
        orderDtos.add(order1);
        orderDtos.add(order2);
        //When
        OrderDto order15 = new OrderDto();
        orderDtos.set(1,order15);
        //Then
        Assert.assertEquals(order15, orderDtos.get(1));
    }

}
