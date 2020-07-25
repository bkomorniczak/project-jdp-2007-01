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

    @GetMapping(value = "getProduct")
    public  ProductDto getProduct(@RequestParam Long productId) {
        return new  ProductDto();
    }


    @DeleteMapping(value = "deleteProduct")
    public void delete(@RequestParam Long productId) {}

    @PutMapping(value = "updateProduct")
    public void updateProduct(@RequestParam ProductDto productDto) {

    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {}
}
