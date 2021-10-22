package com.lollipop.springcloud.controller;

import com.lollipop.springcloud.entity.CommonResult;
import com.lollipop.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: J.K
 * @Date: 2021-10-22 10:13
 * @Description:
 */
@RestController
@RequestMapping("storage")
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping("decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "库存扣减成功，哈哈哈哈");
    }
}
