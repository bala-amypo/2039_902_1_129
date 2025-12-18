package com.example.demo.service;

import com.example.demo.model.BundleRule;
import com.example.demo.repository.BundleRuleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BundleRuleService {

    private final BundleRuleRepository repository;

    public BundleRuleService(BundleRuleRepository repository) {
        this.repository = repository;
    }

    public BundleRule createRule(BundleRule rule) {

        if (rule.getDiscountPercentage() < 0 || rule.getDiscountPercentage() > 100) {
            throw new IllegalArgumentException("Invalid discount");
        }

        return repository.save(rule);
    }

    public BundleRule updateRule(Long id, BundleRule rule) {

        BundleRule existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found"));

        if (rule.getDiscountPercentage() < 0 || rule.getDiscountPercentage() > 100) {
            throw new IllegalArgumentException("Invalid discount");
        }

        existing.setRuleName(rule.getRuleName());
        existing.setRequiredProductIds(rule.getRequiredProductIds());
        existing.setDiscountPercentage(rule.getDiscountPercentage());

        return repository.save(existing);
    }

    public BundleRule getRuleById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found"));
    }

    public List<BundleRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    public void deactivateRule(Long id) {
        BundleRule rule = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("not found"));

        rule.setActive(false);
        repository.save(rule);
    }
}