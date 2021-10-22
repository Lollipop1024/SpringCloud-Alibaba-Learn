package com.lollipop.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: J.K
 * @Date: 2021-10-22 10:24
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    private Long id;
    private Long productId;
    private Integer total;
    /**
     * 已用库存
     */
    private Integer used;
    /**
     * 剩余库存
     */
    private Integer residue;
}
