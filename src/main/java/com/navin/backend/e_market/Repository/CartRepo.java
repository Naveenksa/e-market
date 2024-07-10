package com.navin.backend.e_market.Repository;

import com.navin.backend.e_market.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart,Long> {
}
