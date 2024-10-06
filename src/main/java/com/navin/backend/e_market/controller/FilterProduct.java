package com.navin.backend.e_market.controller;

import com.navin.backend.e_market.Repository.ProductRepo;
import com.navin.backend.e_market.entity.Product;
import com.navin.backend.e_market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/filter")
public class FilterProduct {
    @Autowired
    ProductService productService;

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Product>> getByType(@PathVariable String type){
        List<Product> products=productService.getProductByType(type);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Product> getByName(@PathVariable String name){
        return new ResponseEntity<>(productService.getProductByName(name),HttpStatus.OK);
    }
}
