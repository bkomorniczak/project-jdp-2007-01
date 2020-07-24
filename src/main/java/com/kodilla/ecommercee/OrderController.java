package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @PostMapping
    public void createOrder(@RequestBody OrderDto orderDto) {

    }

    @PostMapping
    public OrderDto updateOrder(@RequestBody Long orderId) {
        return new OrderDto();

    }

    @GetMapping
    public OrderDto getOrder(@RequestParam Long orderId) {
        return new OrderDto();

    }

    @DeleteMapping
    public void deleteOrder(@RequestParam Long orderId) {

    }

    @GetMapping
    public List<OrderDto> getOrders() {
        return new ArrayList<>();

    }
}
