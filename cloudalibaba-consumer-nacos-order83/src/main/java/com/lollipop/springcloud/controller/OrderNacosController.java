package com.lollipop.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: J.K
 * @Date: 2021-09-28 15:55
 * @Description:
 */
@RestController
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String url;

    @GetMapping("/order/getPayment/{id}")
    public String getPaymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(url+"/payment/getPayment/"+id,String.class);
    }
}