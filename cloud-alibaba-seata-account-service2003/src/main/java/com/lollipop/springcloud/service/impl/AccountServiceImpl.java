package com.lollipop.springcloud.service.impl;

import com.lollipop.springcloud.dao.AccountDao;
import com.lollipop.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Author: J.K
 * @Date: 2021-10-22 11:13
 * @Description:
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    /**
     * 扣账户余额
     *
     * @param userId
     * @param money
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("账户扣除余额开始---");
        try {
            // 模拟超时异常，对比使用seata的全局异常注解@GlobalTransactional前后数据库中数据的变化
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        accountDao.decrease(userId, money);
        log.info("账户扣除余额结束---");
    }
}
