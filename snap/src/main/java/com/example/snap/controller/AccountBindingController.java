package com.example.snap.controller;

import com.example.snap.constant.ReturnCodeEnum;
import com.example.snap.exception.AuthException;
import com.example.snap.model.Merchant;
import com.example.snap.repository.MerchantRepository;
import com.example.snap.repository.impl.MerchantRepositoryImpl;
import com.example.snap.service.feign.MerchantService;
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
public class AccountBindingController {
    private final MerchantRepository merchantRepository;
    private final MerchantService merchantService;

    @RequestMapping(
            method = RequestMethod.POST,
            path = "v1/registration-account-binding"
    )
    private ResponseEntity<HashMap<String, Object>> accountBinding(@RequestBody HashMap<String, Object> body) {
        Merchant merchant = merchantRepository.findByMerchantId(String.valueOf(body.get("merchantId"))).orElseThrow(() -> new AuthException(ReturnCodeEnum.PARTNER_NOT_FOUND_07));
        HashMap<String, Object> merchantMap = merchantService.getMerchant(new HashMap<>());
        return new ResponseEntity<>(merchantMap, HttpStatus.ACCEPTED);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "v1/registration-account-inquiry"
    )
    private ResponseEntity<HashMap<String, Object>> accountBindingInquiry(@RequestBody HashMap<String, Object> body) {
        Merchant merchant = merchantRepository.findByMerchantId(String.valueOf(body.get("merchantId"))).orElseThrow(() -> new AuthException(ReturnCodeEnum.PARTNER_NOT_FOUND_07));
        HashMap<String, Object> merchantMap = merchantService.getMerchant(new HashMap<>());
        return new ResponseEntity<>(merchantMap, HttpStatus.ACCEPTED);
    }
}
