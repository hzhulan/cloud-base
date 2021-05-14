package com.fh.controller;

import com.fh.domain.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(value = "/get/{id}")
    public Payment getPayment(@PathVariable("id") Long id) {
        LOGGER.info("=============  访问payment  ============");
        return new Payment(id, "彰显先");
    }

    @RequestMapping("/send")
    public void send(@RequestParam("msg") String msg) {
        kafkaTemplate.send("test", msg);
    }

    @RequestMapping("/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            LOGGER.error("【PaymentController.paymentFeignTimeout】", e);
        }
        return "调用慢接口成功";
    }

    @RequestMapping("/zipkin")
    public String paymentZipkin() {
        return "this is zipkin";
    }

}
