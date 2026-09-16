package com.sougata.ecommerce.project.repositories;

import com.sougata.ecommerce.project.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
