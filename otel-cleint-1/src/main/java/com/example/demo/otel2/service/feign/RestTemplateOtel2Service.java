package com.example.demo.otel2.service.feign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class RestTemplateOtel2Service {

    RestTemplate restTemplate = new RestTemplate();

    public HashMap<String, Object> postSomething(HashMap<String, Object> body) {

        HashMap<String, Object> payload = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(payload, headers);
        ParameterizedTypeReference<Object> responseType = new ParameterizedTypeReference<Object>() {};

        ResponseEntity<Object> responseEntity = restTemplate.exchange(
                "http://localhost:8081/demo/otel2/api",
                HttpMethod.POST,
                requestEntity,
                responseType
        );

        log.info("responseEntity ==> {}", responseEntity.getStatusCode());

        return new HashMap<>();
    }
}
