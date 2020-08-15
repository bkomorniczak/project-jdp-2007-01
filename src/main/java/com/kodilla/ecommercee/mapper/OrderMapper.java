package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.ProductItem;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.repository.ProductItemRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductItemRepository productItemRepository;

    public OrderDto mapToOrderDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getUser().getId(),
                order.getProductItems().stream().map(ProductItem::getId).collect(Collectors.toList()));
    }

    public Order mapToOrder(OrderDto orderDto) throws UserNotFoundException {
        return new Order(
                orderDto.getId(),
                userRepository.findById(orderDto.getUserId()).orElseThrow(UserNotFoundException::new),
                orderDto.getProductItemsId().stream()
                        .map(productItem -> productItemRepository.findById(productItem))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList()));
    }

    public List<OrderDto> mapToOrderDtoList(List<Order> orderList) {
        return orderList.stream()
                .map(order ->
                        new OrderDto(order.getId(),
                                order.getUser().getId(),
                                order.getProductItems().stream()
                                        .map(ProductItem::getId)
                                        .collect(Collectors.toList())))
                .collect(Collectors.toList());
    }
}
