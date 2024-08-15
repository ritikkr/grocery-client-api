package com.groceryapp.client_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Embeddable
public class Address {
    @Column(nullable = false)
    private String addressLine1;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String zipcode;

    // getters and setters
}
//Used @Embedded for the Address class to make it a value object.