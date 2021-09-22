package com.lollipop.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Lollipop
 * @Date: 2021-09-22 21:44
 * @Description:
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
/**
 * 该注解用于向zookeeper或者consul注册服务
 */
@EnableDiscoveryClient
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}
