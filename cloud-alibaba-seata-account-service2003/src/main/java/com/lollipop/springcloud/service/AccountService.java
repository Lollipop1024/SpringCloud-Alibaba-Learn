package com.lollipop.springcloud.service;

import java.math.BigDecimal;

/**
 * @Author: J.K
 * @Date: 2021-10-22 11:12
 * @Description:
 */
public interface AccountService {
    /**
     * 扣账户余额
     *
     * @param userId
     * @param money
     */
    void decrease(Long userId, BigDecimal money);
}
