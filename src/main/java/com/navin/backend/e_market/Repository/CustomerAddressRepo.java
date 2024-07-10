package com.navin.backend.e_market.Repository;

import com.navin.backend.e_market.entity.CustomerAdress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressRepo extends JpaRepository<CustomerAdress,Long> {
}
