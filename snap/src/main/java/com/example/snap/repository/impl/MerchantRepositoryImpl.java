package com.example.snap.repository.impl;

import com.example.snap.model.Merchant;
import com.example.snap.repository.MerchantRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MerchantRepositoryImpl implements MerchantRepository {
    @Override
    public Optional<Merchant> findByMerchantId(String merchantId) {
        if (merchantId.equals("SNAPMERCHANT01")) {
            return Optional.of(new Merchant(merchantId, "SNAP MERCHANT 01"));
        }
        return Optional.empty();
    }
}
