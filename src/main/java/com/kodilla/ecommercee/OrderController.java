package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @GetMapping(value = "getOrders")
    public List<OrderDto> getOrders() {
        return new ArrayList<>();

    }

    @GetMapping
    public OrderDto getOrder(@RequestParam Long orderId) {
        return new OrderDto();

    }

    @DeleteMapping
    public void deleteOrder(@RequestParam Long orderId) {

    }

    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto();

    }

    @PutMapping
    public void updateOrder(@RequestBody Long groupId) {

    }
}
