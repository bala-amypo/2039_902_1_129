package com.example.demo.service;

import com.example.demo.model.DiscountApplication;
import com.example.demo.repository.DiscountApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {

    private final DiscountApplicationRepository repository;

    public DiscountService(DiscountApplicationRepository repository) {
        this.repository = repository;
    }

    public DiscountApplication save(DiscountApplication discount) {
        return repository.save(discount);
    }

    public List<DiscountApplication> getAll() {
        return repository.findAll();
    }
}
