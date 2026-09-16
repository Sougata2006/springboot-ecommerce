package com.sougata.ecommerce.project.service;

import com.sougata.ecommerce.project.payload.CartDTO;

public interface CartService {
    public CartDTO addProductToCart(Long productId, Integer quantity);
}
