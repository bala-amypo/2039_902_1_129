package com.example.demo.service;

import com.example.demo.model.CartItem;
import com.example.demo.repository.CartItemRepository;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {

    private final CartItemRepository repository;

    public CartItemService(CartItemRepository repository) {
        this.repository = repository;
    }

    public CartItem addItem(Long cartId, Long productId, Integer quantity) {
        CartItem item = new CartItem();
        item.setQuantity(quantity);
        return repository.save(item);
    }
}
