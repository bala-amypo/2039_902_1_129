package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import java.math.BigDecimal;
import java.util.*;

public class DiscountServiceImpl {

    private final DiscountApplicationRepository discountRepo;
    private final BundleRuleRepository ruleRepo;
    private final CartRepository cartRepo;
    private final CartItemRepository cartItemRepo;

    public DiscountServiceImpl(
            DiscountApplicationRepository d,
            BundleRuleRepository b,
            CartRepository c,
            CartItemRepository ci) {
        this.discountRepo = d;
        this.ruleRepo = b;
        this.cartRepo = c;
        this.cartItemRepo = ci;
    }

    public List<DiscountApplication> evaluateDiscounts(Long cartId) {
        Cart cart = cartRepo.findById(cartId).orElseThrow();

        // ✅ testEvaluateDiscountsInactiveCartReturnsEmpty
        if (!cart.getActive()) return List.of();

        // ✅ clear previous discounts
        discountRepo.deleteByCartId(cartId);

        List<CartItem> items = cartItemRepo.findByCartId(cartId);
        Map<Long, BigDecimal> priceMap = new HashMap<>();

        for (CartItem i : items) {
            priceMap.put(
                i.getProduct().getId(),
                i.getProduct().getPrice()
                        .multiply(BigDecimal.valueOf(i.getQuantity()))
            );
        }

        List<DiscountApplication> result = new ArrayList<>();

        for (BundleRule rule : ruleRepo.findByActiveTrue()) {
            boolean match = true;
            BigDecimal total = BigDecimal.ZERO;

            for (String id : rule.getRequiredProductIds().split(",")) {
                Long pid = Long.valueOf(id.trim());
                if (!priceMap.containsKey(pid)) {
                    match = false;
                    break;
                }
                total = total.add(priceMap.get(pid));
            }

            if (match) {
                BigDecimal discount = total.multiply(
                        BigDecimal.valueOf(rule.getDiscountPercentage() / 100));

                DiscountApplication app = new DiscountApplication();
                app.setCart(cart);
                app.setBundleRule(rule);
                app.setDiscountAmount(discount);

                result.add(discountRepo.save(app));
            }
        }
        return result;
    }

    public List<DiscountApplication> getApplicationsForCart(Long cartId) {
        return discountRepo.findByCartId(cartId);
    }
}
