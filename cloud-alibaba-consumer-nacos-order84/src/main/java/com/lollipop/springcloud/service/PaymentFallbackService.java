package com.lollipop.springcloud.service;

import com.lollipop.springcloud.entity.CommonResult;
import com.lollipop.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author: J.K
 * @Date: 2021-10-08 16:09
 * @Description:
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
