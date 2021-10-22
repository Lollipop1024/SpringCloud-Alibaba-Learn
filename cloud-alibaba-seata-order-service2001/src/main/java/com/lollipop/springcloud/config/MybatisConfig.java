package com.lollipop.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: J.K
 * @Date: 2021-10-21 15:33
 * @Description:
 */
@Configuration
@MapperScan({"com.lollipop.springcloud.dao"})
public class MybatisConfig {
}
