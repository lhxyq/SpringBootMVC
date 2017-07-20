package com.lh.web.RabbitMQConfig;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by LH 2446059046@qq.com on 2017/7/20.
 */
@Component
public class Receiver implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] bytes = message.getBody();
        System.out.println("收到消息:" + new String(bytes));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
}
