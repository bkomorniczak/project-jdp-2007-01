package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

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
    private int status;

    @Column(name = "USERKEY")
    private Long userKey;

    /*@OneToMany(
            targetEntity = Cart.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Cart> carts;*/

    public User(String username, int status, Long userKey) {
        this.username = username;
        this.status = status;
        this.userKey = userKey;
        /*this.carts = new ArrayList<>();*/
    }

    /*public List<Cart> addCartToUser(Cart cart) {
         return carts.add(cart);
    }*/
}
