package com.lollipop.springcloud.dao;

import com.lollipop.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Author: J.K
 * @Date: 2021-10-11 09:55
 * @Description:
 */
@Mapper
public interface OrderDao {
    /**
     * 创建订单
     *
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态
     *
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
