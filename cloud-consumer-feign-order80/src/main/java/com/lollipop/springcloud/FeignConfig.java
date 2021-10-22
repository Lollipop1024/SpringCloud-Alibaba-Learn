package com.lollipop.springcloud;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: J.K
 * @Date: 2021-09-24 10:12
 * @Description:
 */
@Configuration
public class FeignConfig {
    /**
     * Feign的日志配置
     *
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
