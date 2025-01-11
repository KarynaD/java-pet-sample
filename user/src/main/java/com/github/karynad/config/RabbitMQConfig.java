package com.github.karynad.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public TopicExchange userExchange() {
        return new TopicExchange("user.topic.exchange");
    }

    @Bean
    public FanoutExchange userCreatedExchange() {
        return new FanoutExchange("user.created.fanout.exchange");
    }

}
