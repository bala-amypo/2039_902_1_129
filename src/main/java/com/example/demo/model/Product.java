package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "sku"))
public class Product {

    @Id @GeneratedValue
    private Long id;

    private String sku;
    private String name;
    private String category;
    private BigDecimal price;
    private Boolean active = true;

    private Timestamp createdAt;

    @PrePersist
    void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }
}
