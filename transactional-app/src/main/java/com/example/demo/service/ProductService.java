package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository repo;

    @Transactional
    public void updateStock(Long id, BigDecimal newStock, int delayMs) {
        Gson gson = new Gson();

        Product product = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("product not found"));
        log.info("[{}] original product: {}", newStock, gson.toJson(product));

        try {
            Thread.sleep(delayMs);
        } catch (InterruptedException ignore) {
        }

        product.setStock(newStock);
        repo.saveAndFlush(product);

        log.info("[{}] saveAndFlush stock: {}", newStock, gson.toJson(product));

        Product result = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("product not found"));
        log.info("[{}] Updated stock: {}", newStock, gson.toJson(result));

        log.info("[{}] Updated stock: {}", newStock, gson.toJson(result));

        log.info("[{}] Updated stock: {}", newStock, gson.toJson(result));

        log.info("[{}] Updated stock: {}", newStock, gson.toJson(result));
    }
}
