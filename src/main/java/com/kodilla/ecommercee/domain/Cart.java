package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity (name = "CART")
public class Cart {

    @Id
    @NotNull
    @Column (name = "ID", unique = true)
    private Long id;

    @Column (name = "DESCRIPTION")
    private String description;

/*    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;*/

/*    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private Order order;*/

/*    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "PRODUCTS_CARDS")
    private List<ProductItem> productItem;*/

    public Cart(String description) {
        this.description = description;
        //this.productItem = new ArrayList<>();
    }

/*    public List<ProductItem> addProductToCart (ProductItem productItem) {
        return product.add(ProductItem);
    }*/

/*    public List<ProductItem> removeProductToCart (ProductItem productItem) {
        return product.remove(ProductItem);
    }*/

}

