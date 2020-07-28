package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    /*@ManyToOne(fetch = FetchType.LAZY)
    private User user;*/


   /* @OneToMany(
            targetEntity = OrderedProducts.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderedProducts> orderedProducts;*/
}
