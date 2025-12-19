package com.example.demo.service.impl;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // ✅ Create or reuse active cart
    public Cart createCart(Long userId) {

        return cartRepository
                .findByUserIdAndActiveTrue(userId)
                .orElseGet(() -> {
                    Cart cart = new Cart();
                    cart.setUserId(userId);
                    cart.setActive(true);
                    return cartRepository.save(cart);
                });
    }

    // ✅ Get active cart for user
    public Cart getActiveCartForUser(Long userId) {
        return cartRepository
                .findByUserIdAndActiveTrue(userId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Active cart not found"));
    }

    // ✅ Get cart by id
    public Cart getCartById(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Cart not found"));
    }

    // ✅ Deactivate cart
    public void deactivateCart(Long id) {
        Cart cart = getCartById(id);
        cart.setActive(false);
        cartRepository.save(cart);
    }
}
