package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "USERKEY")
    private Long userKey;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(
            targetEntity = Cart.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Cart> carts;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Order> orders;

    public User(String username, String status, Long userKey, String userEmail, String password) {
        this.username = username;
        this.status = status;
        this.userKey = userKey;
        this.userEmail = userEmail;
        this.password = password;
        this.carts = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public boolean addCartToUser(Cart cart) {
         return carts.add(cart);
    }

}
