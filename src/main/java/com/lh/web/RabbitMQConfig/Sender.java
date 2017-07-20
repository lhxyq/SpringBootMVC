package com.lh.web.RabbitMQConfig;

import com.lh.web.domain.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by LH 2446059046@qq.com on 2017/7/20.
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Jackson2JsonMessageConverter converter;

    public void send(Object object, String routing_key) {
        System.out.println("sender:" + object.toString());
        Message message = converter.toMessage(object, new MessageProperties());
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, routing_key, message);
    }
}
