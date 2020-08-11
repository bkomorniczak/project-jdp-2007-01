package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    private UserMapper userMapper;

    public OrderDto mapToOrderDto(Order order) {
        return new OrderDto(
                order.getId(),
                userMapper.mapToUserDto(order.getUser()),
                order.getProductItems());
    }

    public Order mapToOrder(OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                userMapper.mapToUser(orderDto.getUserDto()),
                orderDto.getProductItems());
    }

    public List<OrderDto> mapToOrderDtoList(List<Order> orderList) {
        return orderList.stream()
                .map(order ->
                        new OrderDto(order.getId(), userMapper.mapToUserDto(order.getUser()), order.getProductItems()))
                .collect(Collectors.toList());
    }
}
