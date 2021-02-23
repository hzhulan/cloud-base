package com.fh.service;

import com.fh.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "COMMON-SERVICE")
public interface PaymentService {

    @RequestMapping("/payment/get/{id}")
    Payment getPaymentById(@PathVariable("id") Long id);

    @RequestMapping("/payment/timeout")
    String paymentFeignTimeout();
}
