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
    public Queue userCreatedQueue() {
        return new Queue("notification.user.created.queue");
    }

    @Bean
    public Binding createdBinding(Queue userCreatedQueue, FanoutExchange userCreatedExchange) {
        return BindingBuilder.bind(userCreatedQueue).to(userCreatedExchange);
    }
}
