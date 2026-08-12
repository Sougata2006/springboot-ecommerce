package com.sougata.ecommerce.project.repositories;

import com.sougata.ecommerce.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
