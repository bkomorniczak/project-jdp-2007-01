package com.kodilla.ecommercee.entities;

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

//    @ManyToOne(optional = false, cascade = CascadeType.ALL)
//    @JoinColumn(name = "GROUP_ID")
//    private Group group;
}
