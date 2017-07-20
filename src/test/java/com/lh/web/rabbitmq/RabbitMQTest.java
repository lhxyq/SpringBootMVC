package com.lh.web.rabbitmq;

import com.lh.web.RabbitMQConfig.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by LH 2446059046@qq.com on 2017/7/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {
    @Autowired
    private Sender sender;

    @Test
    public void sendMessage() {
        sender.send("hello word", "user.add");
    }
}
