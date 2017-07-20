package com.lh.web.RabbitMQConfig;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Created by LH 2446059046@qq.com on 2017/7/20.
 */
@Component
public class Receiver implements ChannelAwareMessageListener {
    @Autowired
    private Jackson2JsonMessageConverter converter;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        EventEntity entity = new EventEntity();
        for (Field field : converter.fromMessage(message).getClass().getDeclaredFields()) {
            for (Field eField : EventEntity.class.getDeclaredFields()) {
                if (eField.getName().equals(field.getName())) {
                    field.setAccessible(true);
                    eField.setAccessible(true);
                    eField.set(entity, field.get(converter.fromMessage(message)));
                }
            }
        }
//        byte[] bytes = message.getBody();
        System.out.println("收到消息:" + entity.toString());
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
