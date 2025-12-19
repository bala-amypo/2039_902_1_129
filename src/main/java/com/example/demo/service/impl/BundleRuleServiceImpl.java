package com.example.demo.service.impl;

import com.example.demo.model.BundleRule;
import com.example.demo.repository.BundleRuleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BundleRuleServiceImpl {

    private final BundleRuleRepository bundleRuleRepository;

    public BundleRuleServiceImpl(BundleRuleRepository bundleRuleRepository) {
        this.bundleRuleRepository = bundleRuleRepository;
    }

    public BundleRule createRule(BundleRule rule) {

        validateRule(rule);

        rule.setActive(true);
        return bundleRuleRepository.save(rule);
    }

    // ✅ Update rule
    public BundleRule updateRule(Long id, BundleRule updated) {

        BundleRule existing = getRuleById(id);

        validateRule(updated);

        existing.setRequiredProductIds(updated.getRequiredProductIds());
        existing.setDiscountPercentage(updated.getDiscountPercentage());

        return bundleRuleRepository.save(existing);
    }

    // ✅ Get rule by id
    public BundleRule getRuleById(Long id) {
        return bundleRuleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bundle rule not found"));
    }

    // ✅ Get active rules
    public List<BundleRule> getActiveRules() {
        return bundleRuleRepository.findByActiveTrue();
    }

    // ✅ Deactivate rule
    public void deactivateRule(Long id) {
        BundleRule rule = getRuleById(id);
        rule.setActive(false);
        bundleRuleRepository.save(rule);
    }

    // 🔒 Common validation logic
    private void validateRule(BundleRule rule) {

        if (rule.getRequiredProductIds() == null ||
            rule.getRequiredProductIds().trim().isEmpty()) {
            throw new IllegalArgumentException("Required products cannot be empty");
        }

        if (rule.getDiscountPercentage() == null ||
            rule.getDiscountPercentage() < 0 ||
            rule.getDiscountPercentage() > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
    }
}
