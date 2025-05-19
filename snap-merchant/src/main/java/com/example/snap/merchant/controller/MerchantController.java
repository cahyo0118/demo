package com.example.snap.merchant.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class MerchantController {
    @RequestMapping(
            method = RequestMethod.POST,
            path = "v1/merchant"
    )
    private ResponseEntity<HashMap<String, Object>> accountBinding(@RequestBody HashMap<String, Object> body) {
        return new ResponseEntity<>(new HashMap<>(), HttpStatus.ACCEPTED);
    }
}
