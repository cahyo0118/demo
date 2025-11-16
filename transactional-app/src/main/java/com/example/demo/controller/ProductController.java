package com.example.demo.controller;

import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping("/{id}/update")
    public Map<String, String> update(
            @PathVariable Long id,
            @RequestParam BigDecimal stock,
            @RequestParam(defaultValue = "0") int delay
    ) {
        service.updateStock(id, stock, delay);
        return Map.of("status", "updated");
    }
}
