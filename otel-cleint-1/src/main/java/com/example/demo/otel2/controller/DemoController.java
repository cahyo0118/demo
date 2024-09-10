package com.example.demo.otel2.controller;


import com.example.demo.otel2.service.feign.Otel2Service;
import com.example.demo.otel2.service.feign.RestTemplateOtel2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/demo/otel1/api")
@Slf4j
public class DemoController {

    @Autowired
    private Otel2Service otel2Service;

    @Autowired
    private RestTemplateOtel2Service restTemplateOtel2Service;

    @PostMapping
    public ResponseEntity<HashMap<String, Object>> postSomething(@RequestBody HashMap<String, Object> body) {

        log.info("POST HIT");
        otel2Service.test2(new HashMap<>());
        otel2Service.postSomething(new HashMap<>());
//        restTemplateOtel2Service.postSomething(new HashMap<>());

        return ResponseEntity.ok(new HashMap<>());
    }
}
