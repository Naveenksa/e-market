package com.navin.backend.e_market.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullName;
    private String email;
    private long phoneNum;
    private String password;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Cart> carts =new ArrayList<>();
}
