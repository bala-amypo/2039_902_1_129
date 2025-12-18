package com.example.demo.service;

import com.example.demo.model.BundleRule;
import com.example.demo.repository.BundleRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BundleRuleService {

    private final BundleRuleRepository repository;

    public BundleRuleService(BundleRuleRepository repository) {
        this.repository = repository;
    }

    public BundleRule createRule(BundleRule rule) {
        return repository.save(rule);
    }

    public List<BundleRule> getAll() {
        return repository.findAll();
    }
}
