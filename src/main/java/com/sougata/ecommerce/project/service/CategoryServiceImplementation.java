package com.sougata.ecommerce.project.service;

import com.sougata.ecommerce.project.exceptions.APIException;
import com.sougata.ecommerce.project.exceptions.ResourceNotFoundException;
import com.sougata.ecommerce.project.model.Category;
import com.sougata.ecommerce.project.payload.CategoryDTO;
import com.sougata.ecommerce.project.payload.CategoryResponse;
import com.sougata.ecommerce.project.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImplementation implements CategoryService {
//    private List<Category> categories = new ArrayList<>();  //As we have shifted to JpaRepo we do not need list anymore
//    private long nextId = 1; //As we have shifted to JpaRepo we do not need list count anymore

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getALLCategories() {

        List<Category> categories = categoryRepository.findAll();

        if (categories.isEmpty()) {
            throw new APIException("No Category created till now !!");
        }

        List<CategoryDTO> categoryDTOS = categories.stream().map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);

        return categoryResponse;
    }

    @Override
    public void createCategory(Category category) {
//        category.setCategoryId(nextId++); //As we have shifted to JpaRepo we do not need list increment anymore
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null) {
            throw new APIException("Category with category name " + category.getCategoryName() + " already exits !!");
        }
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() ->
                new ResourceNotFoundException("Category", "CategoryId", categoryId));

        categoryRepository.delete(category);
        return "Category with category id " + categoryId + " deleted successfully !!";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        Category savedCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
        ;

        category.setCategoryId(categoryId);

        savedCategory = categoryRepository.save(category);
        return savedCategory;
    }
}
