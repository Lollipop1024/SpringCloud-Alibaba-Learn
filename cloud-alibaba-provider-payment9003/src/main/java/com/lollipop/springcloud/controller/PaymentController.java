package com.lollipop.springcloud.controller;

import com.lollipop.springcloud.entity.CommonResult;
import com.lollipop.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: J.K
 * @Date: 2021-10-08 10:16
 * @Description:
 */
@RestController
public class PaymentController {
    /**
     * 模拟dao层
     */
    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L, new Payment(1L, "000000000000000001"));
        hashMap.put(2L, new Payment(2L, "000000000000000002"));
        hashMap.put(3L, new Payment(3L, "000000000000000003"));
    }

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200, "from mysql,serverPort:" + serverPort, payment);
        return result;
    }
}
