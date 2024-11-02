package com.navin.backend.e_market.controller;

import com.navin.backend.e_market.entity.Customer;
import com.navin.backend.e_market.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @PostMapping
    public ResponseEntity<Customer> custmerRegister(@RequestBody Customer customer){
        Customer savedCust= customerService.registerCustomer(customer);
        return new ResponseEntity<>(savedCust, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Customer customer){

        return new ResponseEntity<>(customerService.login(customer.getEmail(),customer.getPassword()),HttpStatus.OK);
    }
}
