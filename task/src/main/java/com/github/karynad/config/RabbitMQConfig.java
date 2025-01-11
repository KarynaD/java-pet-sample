package com.github.karynad.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public FanoutExchange userCreatedExchange() {
        return new FanoutExchange("user.created.fanout.exchange");
    }

    @Bean
    public TopicExchange userExchange() {
        return new TopicExchange("user.topic.exchange");
    }

    @Bean
    public Queue userCreatedQueue() {
        return new Queue("task.user.created.queue");
    }

    @Bean
    public Queue userDeletedQueue() {
        return new Queue("task.user.deleted.queue");
    }

    @Bean
    public Binding userCreatedBinding(Queue userCreatedQueue, FanoutExchange userCreatedExchange) {
        return BindingBuilder.bind(userCreatedQueue).to(userCreatedExchange);
    }

    @Bean
    public Binding userDeletedBinding(Queue userDeletedQueue, TopicExchange userExchange) {
        return BindingBuilder.bind(userDeletedQueue).to(userExchange).with("user.deleted");
    }
}
