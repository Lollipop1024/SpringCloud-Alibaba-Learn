package com.lollipop.loadbalancerule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: J.K
 * @Date: 2021-09-23 16:14
 * @Description: 自定义负载均衡规则
 */
@Configuration
public class CustomizeLoadBalanceRule {
    /**
     * 修改Ribbon默认的负载均衡规则为随机
     *
     * @return
     */
    @Bean
    public IRule customizeRule() {
        return new RandomRule();
    }
}
