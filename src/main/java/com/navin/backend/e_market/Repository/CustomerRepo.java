package com.navin.backend.e_market.Repository;

import com.navin.backend.e_market.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,Long> {

    public Optional<Customer> findByEmailAndPassword(String email, String password);
    public Optional<Customer> findByEmail(String email);
    public Optional<Customer> findBySecretKey(String token);
}
