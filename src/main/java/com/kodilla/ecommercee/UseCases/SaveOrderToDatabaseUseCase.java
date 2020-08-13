package com.kodilla.ecommercee.UseCases;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.ProductItem;
import com.kodilla.ecommercee.repository.OrderRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import com.kodilla.ecommercee.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveOrderToDatabaseUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveOrderToDatabaseUseCase.class);

    public Order invoke(Order order) {
        if(!userRepository.findById(order.getUser().getId()).isPresent()) {
            LOGGER.error("User not found.");
        } else if (checkIfItemExist(order)) {
            orderRepository.save(order);
        }
        return new Order();
    }

    private boolean checkIfItemExist(Order order) {
        List<ProductItem> productList = order.getProductItems();
        boolean existedItem = true;
        for (ProductItem items: productList) {
            if (!productRepository.findById(items.getId()).isPresent()) {
                existedItem = false;
            } else {
                existedItem = true;
            }
        }
        return existedItem;
    }
}
