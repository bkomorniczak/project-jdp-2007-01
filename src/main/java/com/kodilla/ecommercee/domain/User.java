package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "USERS")
public class User {

    public static final String STATUS_ACTIVE = "ACTIVE";
    public static final String STATUS_BLOCK = "BLOCK";

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @NotNull
    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "USERKEY")
    private Long userKey;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

/*    @OneToMany(
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
    private List<Order> orders;*/

    public User(String userName, String status, Long userKey) {
        this.userName = userName;
        this.status = status;
        this.userKey = userKey;
//        this.carts = new ArrayList<>();
//        this.orders = new ArrayList<>();
    }

/*    public List<Cart> addCartToUser(Cart cart) {
         return carts.add(cart);
    }*/
}
