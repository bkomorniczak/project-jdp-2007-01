package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.ProductItem;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.dto.ProductItemDto;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cart")
public class CartController {
    @Autowired
    CartMapper cartMapper;
    @Autowired
    CartService cartService;

    @PostMapping(value = "createCart")
    public Cart createCart(@RequestBody CartDto cartDto){
        return cartService.saveCart(cartMapper.mapToCart(cartDto));

    }

    @GetMapping(value = "getProducts")
    public List<ProductItemDto> getProducts(@RequestParam Long cartId)  {
        return cartMapper.mapToProductItemDtoList(cartService.getCartById(cartId).getProductItems());

    }

    @PutMapping(value = "addProduct")
    public void addProduct(@RequestParam Long cartId, @RequestParam Long productId) {
        cartService.getCartById(cartId).addProductToCart(cartService.getProductById(productId));

    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long cartId, @RequestParam Long productId) {
        cartService.getCartById(cartId).removeProductToCart(cartService.getProductById(productId));

    }

    @PutMapping(value = "createOrder")
    public Order  createOrder(@RequestParam Long cartId){
        return  cartService.createOrder(cartId);

    }
}
