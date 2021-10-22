package com.lollipop.springcloud.service;

/**
 * @Author: J.K
 * @Date: 2021-10-22 10:45
 * @Description:
 */
public interface StorageService {
    /**
     * 减库存
     *
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
