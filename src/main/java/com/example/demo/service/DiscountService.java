package com.example.demo.repository;

import com.example.demo.model.DiscountApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountApplicationRepository
        extends JpaRepository<DiscountApplication, Long> {

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
