package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exception.CartNotFoundException;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/cart")
public class CartController {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private CartService cartService;

    @PostMapping(value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto){
         cartService.saveCart(cartMapper.mapToCart(cartDto));

    }

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts(@RequestParam Long cartId)  {
        return cartMapper.mapToProductDtoList(cartService.getProductItems(cartId));

    }

    @PutMapping(value = "addProduct")
    public void addProduct(@RequestParam Long cartId, @RequestParam Long productId) throws CartNotFoundException, ProductNotFoundException {
        cartService.getCartById(cartId).orElseThrow(CartNotFoundException::new).addProductToCart(cartService.getProductById(productId).orElseThrow(ProductNotFoundException::new));

    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long cartId, @RequestParam Long productId) throws CartNotFoundException, ProductNotFoundException {
        cartService.getCartById(cartId).orElseThrow(CartNotFoundException::new).removeProductToCart(cartService.getProductById(productId).orElseThrow(ProductNotFoundException::new));

    }

    @PutMapping(value = "createOrder")
    public Order createOrder(@RequestParam Long cartId) throws CartNotFoundException {
        return  cartService.createOrder(cartId);

    }
}
