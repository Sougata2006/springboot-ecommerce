package com.sougata.ecommerce.project.service;

import com.sougata.ecommerce.project.model.Product;
import com.sougata.ecommerce.project.payload.ProductDTO;
import com.sougata.ecommerce.project.payload.ProductResponse;

public interface ProductService {
    ProductDTO addProduct(Long categoryId, Product product);

    ProductResponse getAllProducts();

    ProductResponse searchByCategory(Long categoryId);
}
