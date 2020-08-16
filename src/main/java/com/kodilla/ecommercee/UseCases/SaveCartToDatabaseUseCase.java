package com.kodilla.ecommercee.UseCases;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.ProductItem;
import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveCartToDatabaseUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveOrderToDatabaseUseCase.class);

    private boolean checkIfItemExist(Cart cart) {
        List<ProductItem> productItemList = cart.getProductItems();
        boolean existedItem = true;
        for (ProductItem item: productItemList) {
            existedItem = productRepository.findById(item.getId()).isPresent() ? true : false;
        }
        return existedItem;

    }

    public Cart invoke(Cart cart) {
        if(!userRepository.findById(cart.getUser().getId()).isPresent()) {
            LOGGER.error("User not found.");

        } else if (checkIfItemExist(cart)) {
            cartRepository.save(cart);
        }
        return new Cart();

    }
}
