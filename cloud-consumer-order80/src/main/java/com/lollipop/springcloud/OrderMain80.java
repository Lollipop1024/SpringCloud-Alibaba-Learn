package com.lollipop.springcloud;

import com.lollipop.loadbalancerule.CustomizeLoadBalanceRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author: Lollipop
 * @Date: 2021-09-20 23:02
 * @Description:
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
/**
 * 使用自定义的负载均衡规则，不指定使用默认的规则
 */
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = CustomizeLoadBalanceRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
