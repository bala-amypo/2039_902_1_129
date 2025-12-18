package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    private final CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public Cart createCart(@PathVariable Long userId) {
        return service.createCart(userId);
    }
}
