package com.example.demo.model;
import com.example.demo.model.DiscountApplication;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

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

    private Timestamp appliedAt;

    @PrePersist
    public void onApply() {
        appliedAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public BundleRule getBundleRule() {
        return bundleRule;
    }

    public void setBundleRule(BundleRule bundleRule) {
        this.bundleRule = bundleRule;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Timestamp getAppliedAt() {
        return appliedAt;
    }
}
