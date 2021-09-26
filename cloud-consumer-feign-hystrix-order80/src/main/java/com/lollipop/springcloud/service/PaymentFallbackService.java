package com.lollipop.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: J.K
 * @Date: 2021-09-25 14:35
 * @Description:
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_Ok(Integer id) {
        return "PaymentFallbackService paymentInfo_Ok";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "PaymentFallbackService paymentInfo_Timeout";
    }
}
