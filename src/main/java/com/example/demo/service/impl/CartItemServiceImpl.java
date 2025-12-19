package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import jakarta.persistence.EntityNotFoundException;



public class CartItemServiceImpl {

    private final CartItemRepository cartItemRepo;
    private final CartRepository cartRepo;
    private final ProductRepository productRepo;

    public CartItemServiceImpl(CartItemRepository c, CartRepository cr, ProductRepository pr) {
        this.cartItemRepo = c;
        this.cartRepo = cr;
        this.productRepo = pr;
    }

    public CartItem addItemToCart(CartItem item) {
        if (item.getQuantity() <= 0)
            throw new IllegalArgumentException("Quantity must be positive");

        Cart cart = cartRepo.findById(item.getCart().getId())
                .orElseThrow(() -> new EntityNotFoundException("Cart not found"));

        if (!cart.getActive())
            throw new IllegalArgumentException("Only active carts allowed");

        Product product = productRepo.findById(item.getProduct().getId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        return cartItemRepo
                .findByCartIdAndProductId(cart.getId(), product.getId())
                .map(existing -> {
                    existing.setQuantity(existing.getQuantity() + item.getQuantity());
                    return cartItemRepo.save(existing);
                })
                .orElseGet(() -> cartItemRepo.save(item));
    }
}
