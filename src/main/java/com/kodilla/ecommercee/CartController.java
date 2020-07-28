package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.CartItemDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @PostMapping(value = "createCart")
    public void createCart(@RequestBody CartDto cartDto){}

    @GetMapping(value = "getProducts")
    public List<CartItemDto> getProducts(@RequestParam Long cartId) throws CartNotFoundException, ProductNotFoundException{
        return new ArrayList<>();
    }

    @PutMapping(value = "addProduct")
    public void addProduct(@RequestParam Long productId) throws ProductNotFoundException{}

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long productId) throws ProductNotFoundException{}

    @PutMapping(value = "createOrder")
    public void createOrder(@RequestParam Long cartId) throws CartNotFoundException{}
}
