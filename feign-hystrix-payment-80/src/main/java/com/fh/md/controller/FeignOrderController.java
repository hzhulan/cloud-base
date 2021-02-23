package com.fh.md.controller;

import com.fh.md.service.FeignPaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
@DefaultProperties(defaultFallback = "paymentTimeOutHandler")
public class FeignOrderController {

    @Resource
    private FeignPaymentService feignPaymentService;

    @GetMapping("/feign/ok/{id}")
    public String paymentOk(@PathVariable("id") Integer id) {
        return feignPaymentService.paymentOk(id);
    }

//    @HystrixCommand(fallbackMethod = "paymentTimeOutHandler", commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    @GetMapping("/feign/timeout/{id}")
    public String timeOut(@PathVariable("id") Integer id) {
        return feignPaymentService.timeout(id);
    }

    /**
     * 服务降级处理
     * @return
     */
    public String paymentTimeOutHandler() {
        return "消费者80，对方支付系统繁忙，请在10秒后重试!/(ㄒoㄒ)/~~";
    }
}
