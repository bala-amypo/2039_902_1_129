package com.example.demo.service;

import com.example.demo.model.DiscountApplication;
import com.example.demo.repository.DiscountApplicationRepository;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    private final DiscountApplicationRepository repository;

    public DiscountService(DiscountApplicationRepository repository) {
        this.repository = repository;
    }

    public DiscountApplication evaluateDiscounts(Long cartId) {
        DiscountApplication da = new DiscountApplication();
        return repository.save(da);
    }
}
