package com.example.demo.repository;

import com.example.demo.model.BundleRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BundleRuleRepository extends JpaRepository<BundleRule, Long> {

    private final BundleRuleRepository repository;

    public BundleRuleService(BundleRuleRepository repository) {
        this.repository = repository;
    }

    public BundleRule save(BundleRule rule) {
        return repository.save(rule);
    }

    public List<BundleRule> getAll() {
        return repository.findAll();
    }
}
