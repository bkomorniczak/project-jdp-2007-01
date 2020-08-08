package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart saveCart(final Cart cart) {
        return cartRepository.save(cart);

    }

    public Cart getCartById(final Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }


}
