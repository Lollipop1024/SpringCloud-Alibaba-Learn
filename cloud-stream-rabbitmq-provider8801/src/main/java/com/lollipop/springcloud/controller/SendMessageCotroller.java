package com.lollipop.springcloud.controller;

import com.lollipop.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: J.K
 * @Date: 2021-09-27 16:57
 * @Description:
 */
@RestController
public class SendMessageCotroller {
    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("sendMessage")
    public String sendMessage() {
        return iMessageProvider.send();
    }
}
