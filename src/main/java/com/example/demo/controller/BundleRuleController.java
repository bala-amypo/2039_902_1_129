package com.example.demo.controller;

import com.example.demo.model.BundleRule;
import com.example.demo.service.impl.BundleRuleServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bundle-rules")
public class BundleRuleController {

    private final BundleRuleServiceImpl bundleRuleService;

    public BundleRuleController(BundleRuleServiceImpl bundleRuleService) {
        this.bundleRuleService = bundleRuleService;
    }

    @PostMapping
    public BundleRule create(@RequestBody BundleRule rule) {
        return bundleRuleService.createRule(rule);
    }
}
