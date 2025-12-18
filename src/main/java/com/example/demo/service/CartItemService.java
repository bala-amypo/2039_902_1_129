package com.example.demo.service;

import com.example.demo.model.CartItem;
import com.example.demo.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    private final CartItemRepository repository;

    public CartItemService(CartItemRepository repository) {
        this.repository = repository;
    }

    public CartItem save(CartItem item) {
        return repository.save(item);
    }

    public List<CartItem> getAll() {
        return repository.findAll();
    }
}
