package com.lollipop.springcloud.service.impl;

import com.lollipop.springcloud.dao.OrderDao;
import com.lollipop.springcloud.domain.Order;
import com.lollipop.springcloud.service.AccountService;
import com.lollipop.springcloud.service.OrderService;
import com.lollipop.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: J.K
 * @Date: 2021-10-21 15:07
 * @Description: 生成订单->减库存->扣款->订单完成
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    /**
     * 对比加全局事务异常的注解的效果
     *
     * @param order
     */
    @Override
    @GlobalTransactional(name = "my_test_tx_group",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-------->开始创建新订单");
        orderDao.create(order);

        log.info("--------订单微服务开始调用库存,做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-------订单微服务开始调用库存，做扣减end");

        log.info("-------订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-------订单微服务开始调用账户，做扣减end");

        log.info("-------修改订单状态");
        orderDao.update(order.getUserId(), 0);
        log.info("-------修改订单状态结束");

        log.info("--------下订单结束了，哈哈哈哈");
    }
}
