package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.dto.*;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductItemRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CartMapper {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  OrderRepository orderRepository;
    @Autowired
    private ProductItemRepository productItemRepository;

    public Cart mapToCart(CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getDescription(),
                cartDto.getPrice(),
                userRepository.findById(cartDto.getUserId()).orElse(null),
                orderRepository.findById(cartDto.getOrderId()).orElse(null),
                cartDto.getProductDtoList().stream()
                .map(productId -> productId.getId())
                        .map(productItem -> productItemRepository.findById(productItem))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList()));
    }

    public CartDto mapToCartDto(Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getDescription(),
                cart.getPrice(),
                cart.getUser().getId(),
                cart.getOrder().getId(),
                mapToProductDtoList(cart.getProductItems())
        );
    }

    public List<ProductDto> mapToProductDtoList(List<ProductItem> productItems) {
        return productItems.stream()
                .map(product -> new ProductDto(
                        product.getProduct().getId(),
                        product.getProduct().getName(),
                        product.getProduct().getDescription(),
                        product.getProduct().getPrice(),
                        product.getProduct().getGroup().getId()))
                .collect(Collectors.toList());
    }
}
