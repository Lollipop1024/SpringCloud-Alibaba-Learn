package com.lollipop.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.lollipop.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @Author: J.K
 * @Date: 2021-09-27 16:48
 * @Description:
 */

/**
 * 定义消息推送管道
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {
    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = IdUtil.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("======> serial:{}",serial);
        return null;
    }
}
