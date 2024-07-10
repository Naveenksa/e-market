package com.navin.backend.e_market.Repository;

import com.navin.backend.e_market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
}
