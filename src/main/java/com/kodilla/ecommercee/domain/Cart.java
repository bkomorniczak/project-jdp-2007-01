package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity (name = "CART")
public class Cart {

    @Id
    @NotNull
    @Column (name = "ID", unique = true)
    private Long id;

    @Column (name = "NAME")
    private String name;

    @Column (name = "DESCRIPTION")
    private String description;

    @Column (name = "PRICE")
    private int price;

    @Column (name = "GROUPID")
    private int groupID;

    public Cart(String name, String description, int price, int groupId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupID = groupId;
        //this.product = new ArrayList<>();
    }

    /*@OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "ID")
    private User user;*/

    /*@OneToMany(targetEntity = Product.class,
    mappedBy= "user",
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY
    )
    private List<Product> product;*/

/*    public List<Product> addProductToCart (Product product) {
        return product.add(Product);
    }*/

    /*    public List<Product> removeProductToCart (Product product) {
        return product.remove(Product);
    }*/


}

