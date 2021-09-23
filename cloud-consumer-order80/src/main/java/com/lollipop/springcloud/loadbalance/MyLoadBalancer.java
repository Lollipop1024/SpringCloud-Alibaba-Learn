package com.lollipop.springcloud.loadbalance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Lollipop
 * @Date: 2021-09-23 20:17
 * @Description:
 */
@Component
@Slf4j
public class MyLoadBalancer implements LoadBalancer {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncreement() {
        int current;
        // 第几次访问
        int next;
        // CAS自旋锁，使用do-while也一样
        for (; ; ) {
            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current + 1;
            if (this.atomicInteger.compareAndSet(current, next)) {
                log.info("====这是第[{}]次访问", next);
                return next;
            }
        }
    }

    /**
     * 根据自定义的负载均衡算法获取服务实例
     * 负载均衡算法：接口第n次请求%服务集群总数=实际调用服务实例index
     *
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        // 取余实现轮询
        int index = getAndIncreement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
