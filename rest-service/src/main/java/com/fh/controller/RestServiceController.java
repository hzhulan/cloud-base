package com.fh.controller;

import com.fh.domain.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/rest")
public class RestServiceController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/get/{id}")
    public Payment getPayment(@PathVariable("id") Long id) {
        ResponseEntity<Payment> forEntity = restTemplate.getForEntity("http://COMMON-SERVICE/payment/get/" + id, Payment.class);
        return forEntity.getBody();
    }

    //============> zipkin + sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        String result = restTemplate.getForObject("http://common-service/payment/zipkin", String.class);
        return result;
    }
}
