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

   
    @PostMapping("/user/{userId}")
    public Cart createOrGetCart(@PathVariable Long userId) {
        return cartService.createCart(userId);
    }

   
    @GetMapping("/user/{userId}")
    public Cart getActiveCart(@PathVariable Long userId) {
        return cartService.getActiveCartForUser(userId);
    }

   
    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

    
    @PutMapping("/{id}/deactivate")
    public void deactivateCart(@PathVariable Long id) {
        cartService.deactivateCart(id);
    }
}
