package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "CART")
public class Cart {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDERS_ID")
    private Order order;

    @OneToMany(
            targetEntity = ProductItem.class,
            mappedBy = "cart",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<ProductItem> productItems;

    public Cart(String description) {
        this.description = description;
       // this.productItems = new ArrayList<>();
    }

/*    public List<ProductItem> addProductToCart (ProductItem productItem) {
        return product.add(ProductItem);
    }*/

/*    public List<ProductItem> removeProductToCart (ProductItem productItem) {
        return product.remove(ProductItem);
    }*/

}

