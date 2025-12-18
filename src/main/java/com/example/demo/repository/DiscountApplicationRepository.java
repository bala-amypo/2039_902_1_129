package com.example.demo.repository;

import com.example.demo.model.DiscountApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountApplicationRepository extends JpaRepository<DiscountApplication, Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cartId;
    private Double discountAmount;
    private boolean applied;

    public Long getId() {
        return id;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public boolean isApplied() {
        return applied;
    }

    public void setApplied(boolean applied) {
        this.applied = applied;
    }
}
