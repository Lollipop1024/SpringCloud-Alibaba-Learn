package com.lollipop.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Lollipop
 * @Date: 2021-09-20 23:52
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;
}