package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.getProductById(id).orElse(null);

    }
}
