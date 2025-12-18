package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public Cart createCart(@PathVariable Long userId) {
        return service.createCart(userId);
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable Long id) {
        return service.getCartById(id);
    }

    @GetMapping("/user/{userId}")
    public Cart getCartByUser(@PathVariable Long userId) {
        return service.getCartByUserId(userId);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateCart(id);
    }
}