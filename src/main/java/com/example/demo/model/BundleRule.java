package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class BundleRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;

   
    private String requiredProductIds;

    private Double discountPercentage;

    private Boolean active = true;
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

   
    public void setId(Long id) {
        this.id = id;
    }

    
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
