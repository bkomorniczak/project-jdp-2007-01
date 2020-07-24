package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.dto.CartDto;
import com.kodilla.ecommercee.domain.dto.CartItemDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class CartController {

    @PostMapping(value = "createCart")
    public void createCart(@RequestBody CartDto cartDto){}

    @GetMapping(value = "getCart")
    public List<CartItemDto> getCart(@RequestParam Long cartId) throws CartNotFoundException{
        return new ArrayList<>();
    }

    @GetMapping
    public List<CartItemDto> getProducts(@RequestParam Long productId) throws CartNotFoundException{
        return new ArrayList<>();
    }

    @PutMapping(value = "addProduct")
    public void addProduct(@RequestParam Long productId) throws ProductNotFoundException{

    }


    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) throws ProductNotFoundException{}

    @PutMapping(value = "createOrder")
    public void createOrder(@RequestParam Long cartId) throws CartNotFoundException{

    }
}
