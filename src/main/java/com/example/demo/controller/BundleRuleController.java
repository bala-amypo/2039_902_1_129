package com.example.demo.controller;

import com.example.demo.model.BundleRule;
import com.example.demo.service.impl.BundleRuleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bundle-rules")
public class BundleRuleController {

    private final BundleRuleServiceImpl bundleRuleService;

    public BundleRuleController(BundleRuleServiceImpl bundleRuleService) {
        this.bundleRuleService = bundleRuleService;
    }

    // ✅ Create rule
    @PostMapping
    public BundleRule create(@RequestBody BundleRule rule) {
        return bundleRuleService.createRule(rule);
    }

    // ✅ Update rule
    @PutMapping("/{id}")
    public BundleRule update(@PathVariable Long id,
                             @RequestBody BundleRule rule) {
        return bundleRuleService.updateRule(id, rule);
    }

    // ✅ Get rule by id
    @GetMapping("/{id}")
    public BundleRule get(@PathVariable Long id) {
        return bundleRuleService.getRuleById(id);
    }

    // ✅ List active rules
    @GetMapping("/active")
    public List<BundleRule> getActiveRules() {
        return bundleRuleService.getActiveRules();
    }

    // ✅ Deactivate rule
    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        bundleRuleService.deactivateRule(id);
    }
}
