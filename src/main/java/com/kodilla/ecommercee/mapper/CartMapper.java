package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.dto.CartDto;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    public Cart mapToCart(CartDto cartDto) {
        return new Cart(
                cartDto.getId(),
                cartDto.getDescription(),
                cartDto.getPrice(),
                cartDto.getUser()
//                cartDto.getOrder(),
//                cartDto.getProductItems()
        );
    }

    public CartDto mapToCartDto(Cart cart) {
        return new CartDto(
                cart.getId(),
                cart.getDescription(),
                cart.getPrice(),
                cart.getUser()
//                cart.getOrder(),
//                cart.getProductItem()
        );
    }
}
