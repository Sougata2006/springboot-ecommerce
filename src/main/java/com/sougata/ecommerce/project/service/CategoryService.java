package com.sougata.ecommerce.project.service;

import com.sougata.ecommerce.project.model.Category;
import com.sougata.ecommerce.project.payload.CategoryDTO;
import com.sougata.ecommerce.project.payload.CategoryResponse;

public interface CategoryService {
    CategoryResponse getALLCategories();

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
