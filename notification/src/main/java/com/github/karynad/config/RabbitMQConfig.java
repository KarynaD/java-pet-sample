package com.github.karynad.config;

import org.springframework.amqp.core.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "spring.rabbitmq.enabled", havingValue = "true", matchIfMissing = true)
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
