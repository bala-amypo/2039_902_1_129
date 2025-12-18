package com.example.demo.controller;

import com.example.demo.model.BundleRule;
import com.example.demo.service.BundleRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bundle-rules")
public class BundleRuleController {

    private final BundleRuleService service;

    public BundleRuleController(BundleRuleService service) {
        this.service = service;
    }

    @PostMapping
    public BundleRule create(@RequestBody BundleRule rule) {
        return service.createRule(rule);
    }

    @PutMapping("/{id}")
    public BundleRule update(@PathVariable Long id, @RequestBody BundleRule rule) {
        return service.updateRule(id, rule);
    }

    @GetMapping("/{id}")
    public BundleRule getById(@PathVariable Long id) {
        return service.getRuleById(id);
    }

    @GetMapping("/active")
    public List<BundleRule> getActive() {
        return service.getActiveRules();
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        service.deactivateRule(id);
    }
}