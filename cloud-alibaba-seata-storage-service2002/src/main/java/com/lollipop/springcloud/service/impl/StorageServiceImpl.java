package com.lollipop.springcloud.service.impl;

import com.lollipop.springcloud.dao.StorageDao;
import com.lollipop.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: J.K
 * @Date: 2021-10-22 10:49
 * @Description:
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    /**
     * 减库存
     *
     * @param productId
     * @param count
     */
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("库存扣减开始----");
        storageDao.decrease(productId, count);
        log.info("库存扣减结束----");
    }
}
