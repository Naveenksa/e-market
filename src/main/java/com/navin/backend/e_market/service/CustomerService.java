package com.navin.backend.e_market.service;

import com.navin.backend.e_market.entity.Customer;

public interface CustomerService {
    Customer registerCustomer(Customer customer);

    String login(String email,String password);
}
