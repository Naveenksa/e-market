package com.navin.backend.e_market.service;

import com.navin.backend.e_market.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    Product updateRate(long proID,Product product);
    Product addProduct(Product product);
    String deleteProduct(long productId);

    Product getById(long id);



}
