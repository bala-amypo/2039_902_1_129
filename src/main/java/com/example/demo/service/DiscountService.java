package com.example.demo.service;

import com.example.demo.model.DiscountApplication;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class DiscountService {

    public DiscountApplication evaluateDiscount(Long cartId) {

        DiscountApplication discount = new DiscountApplication();
        discount.setCartId(cartId);
        discount.setDiscountAmount(BigDecimal.valueOf(100));
        discount.setApplied(true);

        return discount;
    }
}
