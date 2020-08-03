package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts()   {
        return new ArrayList<>();

    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId)  {
        return new ProductDto();
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {

    }

    @PostMapping(value = "createProduct")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return new ProductDto();
    }

    @PutMapping(value = "updateProduct")
    public void updateProduct(@RequestBody ProductDto productDto)   {

    }



}
