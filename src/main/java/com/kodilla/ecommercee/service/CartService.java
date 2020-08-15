package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.ProductItem;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private OrderRepository orderRepository;

    public Cart saveCart(final Cart cart) {
        return cartRepository.save(cart);

    }

    public Cart getCartById(final Long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    public List<ProductItem> getProductItems(final Long cartId) {
        return cartRepository.findById(cartId).orElse(null).getProductItems();

    }

    public Optional<ProductItem> getProductById(final Long productItemId) {
        return productItemRepository.findById(productItemId);
    }

    public Order createOrder(final Long cartId) {
        return orderRepository.save(getCartById(cartId).getOrder());
    }

}
