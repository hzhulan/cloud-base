package com.fh.md.service;

import org.springframework.stereotype.Component;

@Component
public class FeignPaymentFallbackService implements FeignPaymentService {
    @Override
    public String paymentOk(Integer id) {
        return "paymentOk调用异常，/(ㄒoㄒ)/~~";
    }

    @Override
    public String timeOut(Integer id) {
        return "timeout调用异常，/(ㄒoㄒ)/~~";
    }
}
