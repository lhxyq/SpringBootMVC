package com.lh.web.RabbitMQConfig;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by LH 2446059046@qq.com on 2017/7/20.
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message, String routing_key) {
        System.out.println("sender:" + message);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, routing_key, message);
    }
}
