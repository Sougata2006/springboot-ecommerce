package com.sougata.ecommerce.project.service;

import com.sougata.ecommerce.project.exceptions.APIException;
import com.sougata.ecommerce.project.exceptions.ResourceNotFoundException;
import com.sougata.ecommerce.project.model.Cart;
import com.sougata.ecommerce.project.model.CartItem;
import com.sougata.ecommerce.project.model.Product;
import com.sougata.ecommerce.project.payload.CartDTO;
import com.sougata.ecommerce.project.payload.ProductDTO;
import com.sougata.ecommerce.project.repositories.CartItemRepository;
import com.sougata.ecommerce.project.repositories.CartRepository;
import com.sougata.ecommerce.project.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class CartServiceImplementation implements CartService{

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AuthUtil authUtil;

    @Override
    public CartDTO addProductToCart(Long productId, Integer quantity) {

        Cart cart = createCart();

        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("product", "productId", productId));

        CartItem cartItem = cartItemRepository.findCartItemByProductIdAndCartId(cart.getCartId(), productId);

        if(cartItem != null){
            throw new APIException("Product "+product.getProductName() + "already exists in cart !!");
        }
        if(product.getQuantity() == 0){
            throw new APIException(product.getProductName() + "is not available !!");
        }
        if(product.getQuantity() < quantity){
            throw new APIException("This much item not present please choose within "+ product.getQuantity());
        }

        CartItem newCartItem = new CartItem();
        newCartItem.setProduct(product);
        newCartItem.setCart(cart);
        newCartItem.setQuantity(quantity);
        newCartItem.setDiscount(product.getDiscount());
        newCartItem.setProductPrice(product.getSpecialPrice());

        cartItemRepository.save(newCartItem);

        product.setQuantity(product.getQuantity());

        cart.setTotalPrice(cart.getTotalPrice() + (product.getSpecialPrice() * quantity));
        cartRepository.save(cart);

        CartDTO cartDTO = modelMapper.map(cart, CartDTO.class);

        List<CartItem> cartItems = cart.getCartItems();

        Stream<ProductDTO> productDTOStream = cartItems.stream().map(item -> {
            ProductDTO map = modelMapper.map(item.getProduct(), ProductDTO.class);
            map.setQuantity(item.getQuantity());
            return map;
        });

        cartDTO.setProducts(productDTOStream.toList());


        return cartDTO;
    }

    private Cart createCart(){
        Cart userCart = cartRepository.findCartByEmail(authUtil.loggedInEmail());

        if(userCart != null){
            return userCart;
        }

        Cart cart = new Cart();
        cart.setTotalPrice(0.00);
        cart.setUser(authUtil.loggedInUser);

        Cart newCart = cartRepository.save(cart);

        return newCart;
    }
}
