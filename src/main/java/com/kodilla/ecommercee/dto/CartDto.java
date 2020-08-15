package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.CartItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String groupId;
    private List<CartItem> cartItemList;

}
