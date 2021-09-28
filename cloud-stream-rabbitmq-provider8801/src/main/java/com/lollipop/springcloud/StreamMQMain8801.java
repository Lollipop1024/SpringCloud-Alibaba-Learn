package com.lollipop.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author: J.K
 * @Date: 2021-09-27 16:45
 * @Description:
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class StreamMQMain8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8801.class, args);
    }
}

