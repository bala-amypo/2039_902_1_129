package com.example.demo.service;

import com.example.demo.model.Cart;
import com.example.demo.model.DiscountApplication;
import com.example.demo.repository.DiscountApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountService {

    private final DiscountApplicationRepository discountApplicationRepository;

    public DiscountService(DiscountApplicationRepository discountApplicationRepository) {
        this.discountApplicationRepository = discountApplicationRepository;
    }

    public List<DiscountApplication> getDiscountsByCart(Cart cart) {
        return discountApplicationRepository.findAll()
                .stream()
                .filter(d -> d.getCart().getId().equals(cart.getId()))
                .collect(Collectors.toList());
    }
}
