package com.sougata.ecommerce.project.service;

import com.sougata.ecommerce.project.payload.CartDTO;

import java.util.List;

public interface CartService {
    public CartDTO addProductToCart(Long productId, Integer quantity);

    List<CartDTO> getAllCarts();
}
