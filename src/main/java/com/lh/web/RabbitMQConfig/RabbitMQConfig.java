package com.lh.web.RabbitMQConfig;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Created by LH 2446059046@qq.com on 2017/7/20.
 */
@Configuration
@EnableRabbit
public class RabbitMQConfig {
    public static final String EXCHANGE_NAME = "topic_user";
    public static final String QUEUE0 = "person";
    public static final String QUEUE1 = "people";
    public static final String ROUTTING_KEY_PERSON = "user.*";
    public static final String ROUTTING_KEY_PEOPLE = "user.del";

    // 是否持久化
    private boolean durable = true;
    // 仅创建者可以使用的私有队列，断开后自动删除
    private boolean exclusive = false;
    // 当所有消费客户端连接断开后，是否自动删除队列
    private boolean autoDelete = false;

    /*@Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("127.0.0.1", 5672);

        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setPublisherConfirms(true); // 必须要设置
        return connectionFactory;
    }*/

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME, durable, autoDelete);
    }

    @Bean("personQueue")
    public Queue personQueue() {
        return new Queue(QUEUE0, durable, false, autoDelete);
    }

    @Bean("peopleQueue")
    public Queue peopleQueue() {
        return new Queue(QUEUE1, durable, exclusive, autoDelete);
    }

    @Bean
    @Resource(name = "personQueue")
    public Binding personBinding(Queue personQueue, TopicExchange exchange) {
        return BindingBuilder.bind(personQueue).to(exchange).with(ROUTTING_KEY_PERSON);
    }

    @Bean
    @Resource(name = "peopleQueue")
    public Binding peopleBinding(Queue peopleQueue, TopicExchange exchange) {
        return BindingBuilder.bind(peopleQueue).to(exchange).with(ROUTTING_KEY_PEOPLE);
    }

    /**
     * 绑定多个routting_key
    @Bean
    List<Binding> bindings() {

        return Arrays.AsList(BindingBuilder.bind(queue()).to(exchange()).with(topic1),
                BindingBuilder.bind(queue()).to(exchange()).with(topic2));
    }*/

    @Bean
    public SimpleMessageListenerContainer personListener(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(personQueue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener(listenerAdapter);

        return container;
    }

    @Bean
    public SimpleMessageListenerContainer peopleListener(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(peopleQueue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener(listenerAdapter);

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "onMessage");
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
