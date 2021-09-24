package com.lollipop.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: J.K
 * @Date: 2021-09-24 14:46
 * @Description:
 */
@Component
@FeignClient("CLOUD-HYSTRIX-PAYMENT-SERVICE")
public interface PaymentHystrixService {

    @GetMapping("payment/hystrix/ok/{id}")
    String paymentInfo_Ok(@PathVariable("id") Integer id);

    @GetMapping("payment/hystrix/timeout/{id}")
    String paymentInfo_Timeout(@PathVariable("id") Integer id);
}
