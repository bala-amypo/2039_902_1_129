package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductServiceImpl service;

    public ProductController(ProductServiceImpl service) {
        this.service = service;
    }

    // ✅ Create product
    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.createProduct(product);
    }

    // ✅ Update product
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id,
                          @RequestBody Product product) {
        return service.updateProduct(id, product);
    }

    // ✅ Get product by id
    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        return service.getProductById(id);
    }

    // ✅ List all products
    @GetMapping
    public List<Product> list() {
        return service.getAllProducts();
    }

    // ✅ Deactivate product
    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateProduct(id);
    }
}
