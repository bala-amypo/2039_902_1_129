package com.example.demo.service;

import com.example.demo.model.DiscountApplication;
import com.example.demo.repository.DiscountApplicationRepository;
import org.springframework.stereotype.Service;
@Service
public class DiscountService {

    public DiscountApplication evaluateDiscount(Long cartId) {

        DiscountApplication discount = new DiscountApplication();
        discount.setCartId(cartId);
        discount.setDiscountAmount(100.0);
        discount.setApplied(true);

        return discount;
    }
}
