package com.sougata.ecommerce.project.service;

import com.sougata.ecommerce.project.model.Category;
import com.sougata.ecommerce.project.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getALLCategories();

    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
