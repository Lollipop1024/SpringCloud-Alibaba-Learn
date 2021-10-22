package com.lollipop.springcloud.service;

import com.lollipop.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: J.K
 * @Date: 2021-10-21 15:15
 * @Description:
 */
@Component
@FeignClient(value = "seata-storage-service")
public interface StorageService {
    /**
     * 调用仓库服务减库存
     *
     * @param productId
     * @param count
     * @return
     */
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
