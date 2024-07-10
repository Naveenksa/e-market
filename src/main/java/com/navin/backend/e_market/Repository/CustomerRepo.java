package com.navin.backend.e_market.Repository;

import com.navin.backend.e_market.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
