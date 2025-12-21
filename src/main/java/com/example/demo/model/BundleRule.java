package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class BundleRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

    // CSV of product IDs like "1,2,3"
    private String requiredProductIds;

    private Double discountPercentage;

    private Boolean active = true;

    // ===== getters =====

    public Long getId() {
        return id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getRequiredProductIds() {
        return requiredProductIds;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public Boolean getActive() {
        return active;
    }

    // ===== setters =====

    // ✅ REQUIRED BY TEST CASES
    public void setId(Long id) {
        this.id = id;
    }

    // ✅ REQUIRED BY TEST CASES
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public void setRequiredProductIds(String requiredProductIds) {
        this.requiredProductIds = requiredProductIds;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
