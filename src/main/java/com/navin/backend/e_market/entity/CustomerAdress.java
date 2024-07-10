package com.navin.backend.e_market.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CustomerAdress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String building;
    private String street;
    private String city;

    private String state;
    private long pinCode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
