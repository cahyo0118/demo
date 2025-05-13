package com.example.snap.repository;

import com.example.snap.model.Merchant;

import java.util.Optional;

public interface MerchantRepository {
    Optional<Merchant> findByMerchantId(String merchantId);
}
