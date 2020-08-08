package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "PRODUCT_GROUP")
public class Group {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "group",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Product> productList;

    public Group(String name){
        this.name = name;
        this.productList = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }
}
