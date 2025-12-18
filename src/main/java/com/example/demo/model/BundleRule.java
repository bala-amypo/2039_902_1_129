package com.example.demo.model;

import jakarta.persistence.*;
@Entity
public class BundleRule {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String ruleName;

    private String requiredProducts;
    private Double discountPercentage;
    private Boolean active = true;
}
