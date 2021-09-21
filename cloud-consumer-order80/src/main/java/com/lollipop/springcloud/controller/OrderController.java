package com.lollipop.springcloud.controller;

import com.lollipop.springcloud.entity.CommonResult;
import com.lollipop.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: Lollipop
 * @Date: 2021-09-20 23:07
 * @Description:
 */
@RestController
@Slf4j
public class OrderController {
    //public static final String PAMENT_URL = "http://localhost:8001";
    public static final String PAMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
