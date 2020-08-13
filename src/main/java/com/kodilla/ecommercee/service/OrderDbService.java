package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.UseCases.SaveOrderToDatabaseUseCase;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDbService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private SaveOrderToDatabaseUseCase saveUseCase;

    public Order saveToDatabase(Order order) {
        return saveUseCase.invoke(order);
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Optional<Order> getOrderById(Long orderId) {
        return repository.findById(orderId);
    }

    public void deleteOrderFromDatabase(Long orderId) {
        repository.deleteById(orderId);
    }
}
