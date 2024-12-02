package com.example.demo.keypairvalidator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class AlloSNAPService {

    RestTemplate restTemplate = new RestTemplate();

    public HashMap<String, Object> reqB2B(HashMap<String, Object> body, String currentTimestamp, String signature) {

//        signature = "5f5a9cbf7d14a38d01a7ff5534523a2e1e8e333d7689338b04b0b0bc9b21f4d41ff240fce581af8cc35379dadac24ebaa81104dab87edcff7630d72bad37332ddb67dd2a57b0ae63d78264e6ebbf826f15fc5d35123d9c889eb092a4ad8e04c974333ff49155403a8b001cfef145e85ccfba93682b2df5b080c8880cdc963454bb4ee302077a76a4dc4f2dfeee4130ac21f5fe6e3e47de92df381c14b9a0508970234615f1c2b2eca6ca5df558f4f9047cb875bf5973787c90573e298cdedb0c7ffa27bd406772806a121fd645901787e7e43ecfeacb9ddf88a742d881c89811c4f37d136453ee6a097bf144ef96b57d5989888ff3875d2c0b3cfec5908462ea";
//        currentTimestamp = "2024-12-03T03:35:41+07:00";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-TIMESTAMP", currentTimestamp);
        headers.set("X-CLIENT-KEY", "SNAP01DNA01");
        headers.set("X-SIGNATURE", signature);

        log.info("signature => {}", signature);
        log.info("body ==> {}", headers);
        log.info("headers ==> {}", headers);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        ParameterizedTypeReference<HashMap<String, Object>> responseType = new ParameterizedTypeReference<HashMap<String, Object>>() {
        };

        ResponseEntity<HashMap<String, Object>> responseEntity = restTemplate.exchange(
                "https://uatopenapi.ctcorpmpc.com/sapi/v1.0/access-token/b2b",
                HttpMethod.POST,
                requestEntity,
                responseType
        );

        log.info("responseEntity ==> {}", responseEntity.getStatusCode());
        log.info("responseBody ==> {}", responseEntity.getBody());

        return responseEntity.getBody();
    }
}
