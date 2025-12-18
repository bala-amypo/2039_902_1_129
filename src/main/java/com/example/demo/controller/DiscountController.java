package com.example.demo.controller;

import com.example.demo.model.DiscountApplication;
import com.example.demo.service.DiscountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

    private final DiscountService service;

    public DiscountController(DiscountService service) {
        this.service = service;
    }

    @PostMapping("/evaluate/{cartId}")
    public String evaluate(@PathVariable Long cartId) {
        service.evaluateDiscounts(cartId);
        return "Discounts evaluated";
    }

    @GetMapping("/{id}")
    public DiscountApplication getById(@PathVariable Long id) {
        return service.getApplicationById(id);
    }

    @GetMapping("/cart/{cartId}")
    public List<DiscountApplication> getForCart(@PathVariable Long cartId) {
        return service.getApplicationsForCart(cartId);
    }
}