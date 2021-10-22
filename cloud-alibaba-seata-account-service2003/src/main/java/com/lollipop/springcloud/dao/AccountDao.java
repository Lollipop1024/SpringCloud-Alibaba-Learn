package com.lollipop.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @Author: J.K
 * @Date: 2021-10-22 11:03
 * @Description:
 */
@Mapper
public interface AccountDao {
    /**
     * 扣账户余额
     *
     * @param userId
     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
