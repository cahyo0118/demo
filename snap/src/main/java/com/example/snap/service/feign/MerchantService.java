package com.example.snap.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@FeignClient(name = "merchant-service", url = "http://localhost:8086")
public interface MerchantService {

    @PostMapping(path = "/api/v1/merchant", produces = "application/json")
    HashMap<String, Object> getMerchant(@RequestBody HashMap<String, Object> body);

}
