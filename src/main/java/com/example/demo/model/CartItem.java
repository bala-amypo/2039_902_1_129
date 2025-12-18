package com.example.demo.model;
import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.*;
@Entity
public class CartItem {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Product product;

    private Integer quantity;
}
