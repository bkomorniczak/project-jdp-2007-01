package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.ProductItem;
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
    public List<ProductItem> getProducts(@RequestParam Long cartId)  {
        return cartService.getProductItems(cartId);
    }

    @PutMapping(value = "addProduct")
    public void addProduct(@RequestParam Long cartId, @RequestParam Long productId) {
        cartService.getProductItems(cartId).add(cartService.getProductId(productId));

    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long cartId, @RequestParam Long productId) {
        cartService.getProductItems(cartId).remove(cartService.getProductId(productId));
    }

    @PutMapping(value = "createOrder")
    public void createOrder(@RequestParam Long cartId){
        cartService.createOrder(cartId);
    }
}
