package com.groceryapp.client_api.model;

import com.groceryapp.client_api.model.Address;
import com.groceryapp.client_api.model.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    // getters and setters
}