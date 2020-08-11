package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.ProductItem;
import com.kodilla.ecommercee.dto.ProductItemDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductItemMapper {

    public List<ProductItemDto> mapToProductItemDtoList(List<ProductItem> productItems) {
        return productItems.stream()
                .map(productItem -> new ProductItemDto(productItem.getId(), productItem.getQuantity()))
                .collect(Collectors.toList());
    }

    public List<ProductItem> mapToProductItemList(List<ProductItemDto> productItemDtos) {
        return productItemDtos.stream()
                .map(productItemDto -> new ProductItem(productItemDto.getId(), productItemDto.getQuantity()))
                .collect(Collectors.toList());
    }
}
