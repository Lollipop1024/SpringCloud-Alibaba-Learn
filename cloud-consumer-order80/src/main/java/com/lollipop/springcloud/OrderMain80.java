package com.lollipop.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Lollipop
 * @Date: 2021-09-20 23:02
 * @Description:
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
