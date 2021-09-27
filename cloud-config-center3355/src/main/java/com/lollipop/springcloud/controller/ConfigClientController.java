package com.lollipop.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: J.K
 * @Date: 2021-09-27 08:18
 * @Description:
 */
@RestController
@Slf4j
/**
 * 配置中心修改后刷新同步配置
 */
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("configInfo")
    public String getConfigInfo() {
        return configInfo;
    }
}
