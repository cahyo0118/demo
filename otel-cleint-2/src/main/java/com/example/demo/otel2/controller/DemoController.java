package com.example.demo.otel2.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/demo/otel2/api")
@Slf4j
public class DemoController {

    @PostMapping
    public ResponseEntity<HashMap<String, Object>> postSomething(@RequestBody HashMap<String, Object> body, @RequestHeader HashMap<String, String> headers) {
        log.info("POST HIT");
        StringBuilder headersInfo = new StringBuilder();
        headers.forEach((key, value) -> headersInfo.append(key).append(": ").append(value).append("\n"));
        log.info("HEADERS -> {}", headersInfo);
        return ResponseEntity.ok(new HashMap<>());
    }

    @PostMapping("test-2")
    public ResponseEntity<HashMap<String, Object>> test2(@RequestBody HashMap<String, Object> body, @RequestHeader HashMap<String, String> headers) {
        log.info("POST HIT");
        StringBuilder headersInfo = new StringBuilder();
        headers.forEach((key, value) -> headersInfo.append(key).append(": ").append(value).append("\n"));
        log.info("HEADERS -> {}", headersInfo);
        return ResponseEntity.ok(new HashMap<>());
    }
}
