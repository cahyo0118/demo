package com.example.demo.otel2.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@FeignClient(name = "otel-2-service", url = "http://localhost:8081")
public interface Otel2Service {

    @PostMapping(path = "/demo/otel2/api", produces = "application/json")
    HashMap<String, Object> postSomething(@RequestBody HashMap<String, Object> body);

    @PostMapping(path = "/demo/otel2/api/test-2", produces = "application/json")
    HashMap<String, Object> test2(@RequestBody HashMap<String, Object> body);
}
