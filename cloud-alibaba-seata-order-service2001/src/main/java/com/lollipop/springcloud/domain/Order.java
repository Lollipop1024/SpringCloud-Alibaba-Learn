package com.lollipop.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: J.K
 * @Date: 2021-10-21 14:40
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    /**
     * 订单状态： 0-创建中，1-已完结
     */
    private Integer status;
}
