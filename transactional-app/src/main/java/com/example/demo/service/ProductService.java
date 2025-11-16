package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;

    @Transactional
    public void updateStock(Long id, BigDecimal newStock, int delayMs) {

        Product product = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("product not found"));

        try {
            Thread.sleep(delayMs);
        } catch (InterruptedException ignore) {
        }

        product.setStock(newStock);
    }
}
