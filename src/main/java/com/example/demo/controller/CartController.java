package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.service.impl.CartServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartServiceImpl service;

    public CartController(CartServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/user/{userId}")
    public Cart create(@PathVariable Long userId) {
        return service.createCart(userId);
    }

    @GetMapping("/user/{userId}")
    public Cart get(@PathVariable Long userId) {
        return service.getActiveCartForUser(userId);
    }
}
