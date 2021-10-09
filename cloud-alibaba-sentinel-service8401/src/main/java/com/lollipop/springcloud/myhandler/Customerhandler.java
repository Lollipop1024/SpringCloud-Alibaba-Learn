package com.lollipop.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lollipop.springcloud.entity.CommonResult;
import com.lollipop.springcloud.entity.Payment;

/**
 * @Author: J.K
 * @Date: 2021-10-08 09:19
 * @Description: 全局统一兜底方案
 */
public class Customerhandler {
    public CommonResult handlerException(BlockException exception) {
        return new CommonResult(444,"按客户自定义，global handlerException",new Payment(2020L,"serial001"));
    }

    public CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444,"按客户自定义，global handlerException2",new Payment(2020L,"serial002"));
    }
}
