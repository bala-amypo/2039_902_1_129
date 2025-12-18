package com.example.demo.controller;

import com.example.demo.model.DiscountApplication;
import com.example.demo.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/discounts")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    /**
     * Evaluate discount for a cart
     */
    @PostMapping("/evaluate/{cartId}")
    public DiscountApplication evaluateDiscount(@PathVariable Long cartId) {
        return discountService.evaluateDiscount(cartId);
    }
}
