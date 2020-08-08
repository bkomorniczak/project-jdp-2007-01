package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private  String description;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "GROUP_ID")
    private Group group;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "PRODUCTS_ORDERS",
//            joinColumns = { @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
//            inverseJoinColumns = { @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")}
//    )
//    private Order order;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "PRODUCTS_CARDS",
//            joinColumns = { @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
//            inverseJoinColumns = { @JoinColumn(name = "CARD_ID", referencedColumnName = "CARD_ID")}
//    )
//    private Cart cart;
}
