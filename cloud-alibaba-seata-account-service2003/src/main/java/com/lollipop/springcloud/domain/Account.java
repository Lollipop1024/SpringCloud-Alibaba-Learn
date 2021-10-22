package com.lollipop.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: J.K
 * @Date: 2021-10-22 11:08
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private Long userId;
    /**
     * 总额度
     */
    private BigDecimal total;
    /**
     * 已用额度
     */
    private BigDecimal used;
    /**
     * 剩余额度
     */
    private BigDecimal residue;
}
