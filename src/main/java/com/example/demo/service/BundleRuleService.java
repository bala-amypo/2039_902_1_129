package com.example.demo.service;

import com.example.demo.model.BundleRule;
import com.example.demo.repository.BundleRuleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BundleRuleService {

    private final BundleRuleRepository bundleRuleRepository;

    public BundleRuleService(BundleRuleRepository bundleRuleRepository) {
        this.bundleRuleRepository = bundleRuleRepository;
    }

    public List<BundleRule> getAll() {
        return bundleRuleRepository.findAll();
    }
}
