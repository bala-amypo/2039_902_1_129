package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.service.impl.CartServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartServiceImpl cartService;

    public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }

    // ✅ Create or get active cart for user
    @PostMapping("/user/{userId}")
    public Cart createOrGetCart(@PathVariable Long userId) {
        return cartService.createCart(userId);
    }

    // ✅ Get active cart for user
    @GetMapping("/user/{userId}")
    public Cart getActiveCart(@PathVariable Long userId) {
        return cartService.getActiveCartForUser(userId);
    }

    // ✅ Get cart by cart id
    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

    // ✅ Deactivate cart
    @PutMapping("/{id}/deactivate")
    public void deactivateCart(@PathVariable Long id) {
        cartService.deactivateCart(id);
    }
}
