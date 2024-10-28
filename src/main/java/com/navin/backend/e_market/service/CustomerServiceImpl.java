package com.navin.backend.e_market.service;

import com.navin.backend.e_market.Repository.CustomerRepo;
import com.navin.backend.e_market.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    CustomerRepo customerRepo;

    public Customer addCust(Customer customer){
        return customerRepo.save(customer);
    }
}
