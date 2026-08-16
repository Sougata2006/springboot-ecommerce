package com.sougata.ecommerce.project.repositories;

import com.sougata.ecommerce.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
