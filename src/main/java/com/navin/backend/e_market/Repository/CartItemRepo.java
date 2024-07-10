package com.navin.backend.e_market.Repository;

import com.navin.backend.e_market.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepo extends JpaRepository<CartItem,Long> {
}
