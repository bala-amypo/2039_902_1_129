package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class DiscountApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private BundleRule bundleRule;

    private BigDecimal discountAmount;

    private LocalDateTime appliedAt = LocalDateTime.now();

    // getters & setters
    public void setCart(Cart cart) { this.cart = cart; }
    public void setBundleRule(BundleRule bundleRule) { this.bundleRule = bundleRule; }
    public void setDiscountAmount(BigDecimal discountAmount) { this.discountAmount = discountAmount; }
}
