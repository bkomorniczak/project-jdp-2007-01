package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.dto.*;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  OrderRepository orderRepository;
    @Autowired
    private GroupRepository groupRepository;

    public Cart mapToCart(CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getDescription(),
                cartDto.getPrice(),
                userRepository.findById(cartDto.getUserDto()).orElse(null),
                orderRepository.findById(cartDto.getOrderDto()).orElse(null),
                mapToProductItemList(cartDto.getProductDtoList())
        );
    }

    public CartDto mapToCartDto(Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getDescription(),
                cart.getPrice(),
                cart.getUser().getId(),
                cart.getOrder().getId(),
                mapToProductItemDtoList(cart.getProductItems())
        );
    }

    public List<ProductItemDto> mapToProductItemDtoList(List<ProductItem> productItems) {
        return productItems.stream()
                .map(productItem -> new ProductItemDto(productItem.getId(), productItem.getQuantity()))
                .collect(Collectors.toList());
    }


    public List<ProductItem> mapToProductItemList(List<ProductItemDto> productItemDtoList) {
        return productItemDtoList.stream()
                .map(productItemDto -> new ProductItem(productItemDto.getId(), productItemDto.getQuantity()))
                .collect(Collectors.toList());
    }

    public OrderDto mapToOrderDto( Order order) {
        return new OrderDto(
                order.getId(),
                order.getUser().getId(),
                mapToProductItemDtoList(order.getProductItems())
        );
    }
}
