package com.lollipop.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: J.K
 * @Date: 2021-09-30 08:52
 * @Description:
 */
@RestController
@Slf4j
public class FlowLimitController {
    @RequestMapping("testA")
    public String testA() {
        return "testA-------";
    }

    @RequestMapping("testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "testB");
        return "testB-------";
    }

    @RequestMapping("/testC")
    public String testC() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testC,测试RT");
        return "testC 测试RT-------";
    }

    @RequestMapping("/testD")
    public String testD() {
        log.info("testD 异常比例测试");
        int age = 10 / 0;
        return "testD-------";
    }

    @RequestMapping("testE")
    public String testE() {
        log.info("testD 异常s数--测试");
        int age = 10 / 0;
        return "testD-------";
    }

    /**
     * 类似于OpenFeign的Fallback
     *
     * @param p1
     * @param p2
     * @return
     */
    @RequestMapping("testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKet")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2) {
        log.info("testHotKey 热点Key--测试");
        //int age = 10 / 0;
        return "testHotKey-------";
    }

    public String deal_testHotKet(String p1, String p2, BlockException e) {
        return "----deal_testHotKet,------";
    }
}
