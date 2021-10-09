package com.lollipop.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: J.K
 * @Date: 2021-10-08 10:15
 * @Description:
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class NacosProviderMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9003.class, args);
    }
}
