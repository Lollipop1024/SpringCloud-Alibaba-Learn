package com.lollipop.springcloud.controller;

import com.lollipop.springcloud.domain.CommonResult;
import com.lollipop.springcloud.domain.Order;
import com.lollipop.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: J.K
 * @Date: 2021-10-21 15:31
 * @Description:
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功！");
    }
}
