package com.example.snap.payment.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PaymentController {

    @RequestMapping(
            method = RequestMethod.POST,
            path = "v1/debit/payment-host-to-host"
    )
    private ResponseEntity<HashMap<String, Object>> accountBinding(@RequestBody HashMap<String, Object> body) {
        log.info("[snap-payment][v1/debit/payment-host-to-host]");
        return new ResponseEntity<>(new HashMap<>(), HttpStatus.ACCEPTED);
    }
}
