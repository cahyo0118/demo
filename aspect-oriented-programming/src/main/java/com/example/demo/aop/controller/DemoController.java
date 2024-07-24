package com.example.demo.aop.controller;

import com.example.demo.logclient.utils.Layer1;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(path = "/demo")
public class DemoController {

    @GetMapping
    public ResponseEntity<HashMap<String, Object>> getSomething() {
        Layer1 layer1 = new Layer1();
        layer1.callLayer2();
        return ResponseEntity.ok(new HashMap<>());
    }
}
