package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ORDERED_PRODUCTS")
public class ProductItem {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @NotNull
    @Column
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cart cart;

    public ProductItem(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

}
