package com.lollipop.springcloud.service;

import com.lollipop.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author: J.K
 * @Date: 2021-10-21 15:06
 * @Description:
 */
@Component
@FeignClient(value = "seata-account-service")
public interface AccountService {
    /**
     * 调用用户服务减余额
     *
     * @param userId
     * @param money
     * @return
     */
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
