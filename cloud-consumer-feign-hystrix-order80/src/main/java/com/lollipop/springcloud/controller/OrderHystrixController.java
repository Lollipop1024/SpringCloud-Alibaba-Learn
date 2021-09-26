package com.lollipop.springcloud.controller;

import com.lollipop.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: J.K
 * @Date: 2021-09-24 15:24
 * @Description:
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_Ok(id);
        return result;
    }

    @GetMapping("consumer/payment/hystrix/timeout/{id}")
    /**
     * 若指定了具体的降级方法，则使用指定的，否则使用全局的降级方法
     */
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfo_Timeout(id);
        return result;
    }


    /**
     * 模拟复杂业务-一旦报错或超时（3000ms），执行指定fallbackMethod
     *
     * @param id
     * @return
     */
    @GetMapping("consumer/payment/hystrix/timeout2/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String paymentInfo_Timeout2(@PathVariable("id") Integer id) {
        //int i = 10 / 0;
        String result = paymentHystrixService.paymentInfo_Timeout(id);
        return result;
    }

    /**
     * 降级兜底方案,一旦复杂业务接口超时或者报错，执行此方法保证其他服务正常运行
     *
     * @param id
     * @return
     */
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "消费者80，对方系统繁忙或者自身系统出错，请稍后重试";
    }


    /**
     * 全局fallback方法
     *
     * @return
     */
    public String payment_Global_FallbackMethod() {
        return "Global异常信息处理方法";
    }
}
