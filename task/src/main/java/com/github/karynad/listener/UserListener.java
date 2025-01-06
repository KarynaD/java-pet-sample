package com.github.karynad.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserListener {

    @RabbitListener(queues = "user-created-queue")
    public void handleUserCreated(String json) {
        System.out.println("Creating tasks for user: " + json);
        // Логика создания приветственных задач для нового пользователя
    }
}
