package com.lollipop.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: J.K
 * @Date: 2021-09-24 10:58
 * @Description:
 */
@Service
public class PaymentService {
    /**
     * 访问正常的方法
     *
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_Ok, id " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * 模拟复杂业务
     *
     * @param id
     * @return
     */
    public String paymentInfo_Timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int time = 3;
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_Timeout, id " + id + "\t" + "耗时：" + time;
    }
}
