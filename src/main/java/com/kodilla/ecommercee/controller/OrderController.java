package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.service.OrderDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @Autowired
    private OrderDbService service;

    @Autowired
    private OrderMapper mapper;

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return mapper.mapToOrderDtoList(service.getAllOrders());

    }

    @GetMapping(value = "getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) {
        return mapper.mapToOrderDto(service.getOrderById(orderId).orElseThrow(null));

    }

    @DeleteMapping(value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {
        service.deleteOrderFromDatabase(orderId);
    }

    @PostMapping(value = "createOrder")
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return mapper.mapToOrderDto(service.saveToDatabase(mapper.mapToOrder(orderDto)));

    }

    @PutMapping(value = "updateOrder")
    public void updateOrder(@RequestBody OrderDto orderDto) {
        service.saveToDatabase(mapper.mapToOrder(orderDto));
    }
}
