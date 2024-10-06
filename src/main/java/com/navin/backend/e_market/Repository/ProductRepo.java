package com.navin.backend.e_market.Repository;

import com.navin.backend.e_market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
public Optional<List<Product>> findByProductType(String type);

public Product findByProductName(String name);
}
