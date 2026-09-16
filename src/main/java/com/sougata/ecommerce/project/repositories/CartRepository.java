package com.sougata.ecommerce.project.repositories;

import com.sougata.ecommerce.project.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
