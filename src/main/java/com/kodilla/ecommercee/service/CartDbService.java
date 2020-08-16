package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.UseCases.SaveCartToDatabaseUseCase;
import com.kodilla.ecommercee.UseCases.SaveOrderToDatabaseUseCase;
import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.ProductItem;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartDbService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private SaveCartToDatabaseUseCase saveUseCase;

    public Cart saveCart(final Cart cart) {
        return saveUseCase.invoke(cart);

    }

    public Optional<Cart> getCartById(final Long cartId) {
        return cartRepository.findById(cartId);
    }

    public List<ProductItem> getProductItems(final Long cartId) throws CartNotFoundException {
        return cartRepository.findById(cartId).orElseThrow(CartNotFoundException::new).getProductItems();

    }

    public Optional<ProductItem> getProductById(final Long productItemId) {
        return productItemRepository.findById(productItemId);
    }

    public Order createOrder(final Long cartId) throws CartNotFoundException {
        return orderRepository.save(getCartById(cartId).orElseThrow(CartNotFoundException::new).getOrder());
    }

}
