package com.sougata.ecommerce.project.service;

import com.sougata.ecommerce.project.model.Category;
import com.sougata.ecommerce.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplementation implements CategoryService {
//    private List<Category> categories = new ArrayList<>();  //As we have shifted to JpaRepo we do not need list anymore
//    private long nextId = 1; //As we have shifted to JpaRepo we do not need list count anymore

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getALLCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
//        category.setCategoryId(nextId++); //As we have shifted to JpaRepo we do not need list increment anymore
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found !!"));

        categoryRepository.delete(category);
        return "Category with category id " + categoryId + " deleted successfully !!";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        Optional<Category> savedCategoryOptional = categoryRepository.findById(categoryId);

        Category savedCategory = savedCategoryOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found !!"));

        category.setCategoryId(categoryId);

        savedCategory = categoryRepository.save(category);
        return savedCategory;
    }
}
