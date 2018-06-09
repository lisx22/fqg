package com.fqg.service.qiantai.impl;
import com.fqg.util.RedisUtil;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;

public class RabbitmqService implements MessageListener {
    @Autowired
    RedisUtil redisUtil;
    public void onMessage(Message message) {
        System.out.println("消息消费者 = " + message.toString());
       redisUtil.set("消息消费者","haha");
    }
}