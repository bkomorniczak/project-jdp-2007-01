package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.CartItemDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {
    @Autowired
    CartMapper cartMapper;
    @Autowired
    CartService cartService;

    @PostMapping(value = "createCart")
    public void createCart(@RequestBody CartDto cartDto){
        cartService.saveCart(cartMapper.mapToCart(cartDto));
    }

    @GetMapping(value = "getProducts")
    public List<CartItemDto> getProducts(@RequestParam Long cartId) throws CartNotFoundException, ProductNotFoundException {
        return new ArrayList<>();
    }

    @PutMapping(value = "addProduct")
    public void addProduct(@RequestParam Long productId, @RequestParam Long cartId) throws ProductNotFoundException, CartNotFoundException{}

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long productId, @RequestParam Long cartId) throws ProductNotFoundException, CartNotFoundException{}

    @PutMapping(value = "createOrder")
    public void createOrder(@RequestParam Long cartId) throws CartNotFoundException{}
}
