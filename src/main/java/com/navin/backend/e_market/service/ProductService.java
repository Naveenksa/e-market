package com.navin.backend.e_market.service;

import com.navin.backend.e_market.entity.Product;
import com.navin.backend.e_market.entity.ProductPatch;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    Product updateProduct(long proID, Product product);
    Product addProduct(Product product);
    String deleteProduct(long productId);

    Product getById(long id);
    List<Product> getProductByType(String type);
    Product getProductByName(String name);
    List<Product> getSortedProductByName();

    Product patchProduct(Long id, ProductPatch productPatch);
}

