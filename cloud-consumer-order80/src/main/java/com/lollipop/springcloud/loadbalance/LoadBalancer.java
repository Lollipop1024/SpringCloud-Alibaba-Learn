package com.lollipop.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: Lollipop
 * @Date: 2021-09-23 20:12
 * @Description:
 */
public interface LoadBalancer {
    /**
     * 获取所有服务实例
     *
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
