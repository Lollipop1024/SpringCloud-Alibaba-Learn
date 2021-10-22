package com.lollipop.springcloud;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: J.K
 * @Date: 2021-09-23 14:46
 * @Description:
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    /**
     *  开启RestTemplate负载均衡，这样可以通过服务名称访问。默认为轮询
     */
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
