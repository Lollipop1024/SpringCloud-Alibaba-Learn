package com.lollipop.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Lollipop
 * @Date: 2021-09-20 23:11
 * @Description:
 */
@Configuration
public class ApplicatonContextConfig {
    @Bean
    /**
     *  开启RestTemplate负载均衡，这样可以通过服务名称访问。默认为轮询
     */
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
