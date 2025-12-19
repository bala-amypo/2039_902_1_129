package com.example.demo.controller;

import com.example.demo.model.BundleRule;
import com.example.demo.service.impl.BundleRuleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bundle-rules")
public class BundleRuleController {

    private final BundleRuleServiceImpl service;

    public BundleRuleController(BundleRuleServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public BundleRule create(@RequestBody BundleRule rule) {
        return service.createRule(rule);
    }

    @GetMapping("/active")
    public List<BundleRule> activeRules() {
        return service.getActiveRules();
    }
}
