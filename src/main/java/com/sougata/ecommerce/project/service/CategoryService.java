package com.sougata.ecommerce.project.service;

import com.sougata.ecommerce.project.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getALLCategories();

    void createCategory(Category category);

    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
