package com.example.demo.controller;

import com.example.demo.model.CartItem;
import com.example.demo.service.CartItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart-items")
public class CartItemController {

    private final CartItemService service;

    public CartItemController(CartItemService service) {
        this.service = service;
    }

    @PostMapping
    public CartItem addItem(@RequestParam Long cartId,
                            @RequestParam Long productId,
                            @RequestParam Integer quantity) {
        return service.addItem(cartId, productId, quantity);
    }
}
