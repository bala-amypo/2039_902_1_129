package com.example.demo.model;

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
