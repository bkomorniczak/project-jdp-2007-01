package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.ProductItem;
import com.kodilla.ecommercee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private User user;
    private List<ProductItem> productItems;

}
