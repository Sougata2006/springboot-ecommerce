package com.sougata.ecommerce.project.repositories;

import com.sougata.ecommerce.project.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
