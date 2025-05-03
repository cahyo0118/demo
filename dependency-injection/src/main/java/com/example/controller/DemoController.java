package com.example.controller;


import com.example.service.SampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/api/v1")
@Slf4j
public class DemoController {

    @Autowired
    private SampleService sampleService;

    @PostMapping("/post-something")
    public ResponseEntity<HashMap<String, Object>> postSomething(@RequestBody HashMap<String, Object> body) {

        return ResponseEntity.ok(new HashMap<>());
    }
}
