package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class DiscountServiceImpl {

    private final DiscountApplicationRepository discountRepo;
    private final BundleRuleRepository ruleRepo;
    private final CartRepository cartRepo;
    private final CartItemRepository cartItemRepo;

    public DiscountServiceImpl(
            DiscountApplicationRepository discountRepo,
            BundleRuleRepository ruleRepo,
            CartRepository cartRepo,
            CartItemRepository cartItemRepo) {
        this.discountRepo = discountRepo;
        this.ruleRepo = ruleRepo;
        this.cartRepo = cartRepo;
        this.cartItemRepo = cartItemRepo;
    }

   
    public DiscountApplication getDiscountById(Long id) {
        return discountRepo.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Discount application not found"));
    }

   
    public List<DiscountApplication> getApplicationsForCart(Long cartId) {
        return discountRepo.findByCartId(cartId);
    }

   
    public List<DiscountApplication> evaluateDiscounts(Long cartId) {

        Cart cart = cartRepo.findById(cartId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Cart not found"));

        if (!cart.getActive()) {
            return List.of();
        }

     
        discountRepo.deleteByCartId(cartId);

        List<CartItem> items = cartItemRepo.findByCartId(cartId);
        Map<Long, BigDecimal> priceMap = new HashMap<>();

        for (CartItem item : items) {
            priceMap.put(
                    item.getProduct().getId(),
                    item.getProduct().getPrice()
                            .multiply(BigDecimal.valueOf(item.getQuantity()))
            );
        }

        List<DiscountApplication> result = new ArrayList<>();

        for (BundleRule rule : ruleRepo.findByActiveTrue()) {

            boolean match = true;
            BigDecimal total = BigDecimal.ZERO;

            for (String pidStr : rule.getRequiredProductIds().split(",")) {
                Long pid = Long.valueOf(pidStr.trim());

                if (!priceMap.containsKey(pid)) {
                    match = false;
                    break;
                }
                total = total.add(priceMap.get(pid));
            }

            if (match) {
                BigDecimal discountAmount = total.multiply(
                        BigDecimal.valueOf(rule.getDiscountPercentage() / 100.0)
                );

                DiscountApplication app = new DiscountApplication();
                app.setCart(cart);
                app.setBundleRule(rule);
                app.setDiscountAmount(discountAmount);
                app.setAppliedAt(LocalDateTime.now());

                result.add(discountRepo.save(app));
            }
        }

        return result;
    }
}
