package com.example.demo.controller;

import com.example.demo.model.DiscountApplication;
import com.example.demo.service.impl.DiscountServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discounts")
public class DiscountController {

    private final DiscountServiceImpl service;

    public DiscountController(DiscountServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/evaluate/{cartId}")
    public List<DiscountApplication> evaluate(@PathVariable Long cartId) {
        return service.evaluateDiscounts(cartId);
    }

    // ✅ MISSING ENDPOINT (FIX)
    @GetMapping("/{id}")
    public DiscountApplication getById(@PathVariable Long id) {
        return service.getDiscountById(id);
    }

    @GetMapping("/cart/{cartId}")
    public List<DiscountApplication> getForCart(@PathVariable Long cartId) {
        return service.getApplicationsForCart(cartId);
    }
}
