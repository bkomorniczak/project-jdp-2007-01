package com.kodilla.ecommercee;

import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts(){
        return new ArrayList<>();
    }

    @GetMapping
    public  ProductDto getProduct(@RequestParam Long productId) {
        return new  ProductDto();
    }


    @DeleteMapping
    public void delete(@RequestParam Long productId) {}

    @PutMapping
    public ProductDto updateProduct(@RequestBody Long productId) {
        return new ProductDto();
    }

    @PostMapping
    public void createProduct(@RequestBody ProductDto productDto) {}
}
