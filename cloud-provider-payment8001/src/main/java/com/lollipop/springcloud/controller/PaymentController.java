package com.lollipop.springcloud.controller;

import com.lollipop.springcloud.entity.CommonResult;
import com.lollipop.springcloud.entity.Payment;
import com.lollipop.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Lollipop
 * @Date: 2021-09-17 21:56
 * @Description:
 */
@RestController
@Slf4j
public class PaymentController {
    /**
     * 服务对象
     */
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> selectOne(@PathVariable("id") Long id) {
        Payment payment = this.paymentService.queryById(id);
        if (payment != null) {
            return new CommonResult<>(200, "select success server port:" + serverPort, payment);
        } else {
            return new CommonResult<>(400, "select failure server port:" + serverPort, null);
        }
    }

    /**
     * 插入数据
     *
     * @param payment
     * @return
     */
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int insertResult = this.paymentService.insert(payment);
        log.info("插入结果:-->[{}]", insertResult);
        if (insertResult > 0) {
            return new CommonResult<>(200, "insert success server port:" + serverPort, insertResult);
        } else {
            return new CommonResult<>(300, "insert failure server port:" + serverPort, null);
        }
    }

    /**
     * 服务发现
     *
     * @return
     */
    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(s -> log.info("services:{}", s));
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(s -> log.info(s.getInstanceId() + "\t" + s.getHost() + "\t" + s.getPort() + "\t" + s.getUri()));
        return this.discoveryClient;
    }

}




