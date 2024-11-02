package com.navin.backend.e_market.service;

import com.navin.backend.e_market.Repository.CustomerRepo;
import com.navin.backend.e_market.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService{
   // public static final String SECREATE_KEY = "g5g5g5g5g5g";
    @Autowired
    CustomerRepo customerRepo;

    public Customer registerCustomer(Customer customer){
        String token=UUID.randomUUID().toString();
          customer.setSecretKey(token);
        return customerRepo.save(customer);
    }

    @Override
    public String login(String email, String password) {
        return customerRepo.findByEmailAndPassword(email, password)
                .map(c ->c.getSecretKey()).orElseThrow();
    }
}
