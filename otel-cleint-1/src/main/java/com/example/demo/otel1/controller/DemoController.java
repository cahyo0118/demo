package com.example.demo.otel1.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/demo/otel1/api")
@Slf4j
public class DemoController {

    @PostMapping
    public ResponseEntity<HashMap<String, Object>> postSomething(@RequestBody HashMap<String, Object> body) {
        log.info("POST HIT");
        return ResponseEntity.ok(new HashMap<>());
    }
}
