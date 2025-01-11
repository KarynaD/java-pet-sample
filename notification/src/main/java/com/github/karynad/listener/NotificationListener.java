package com.github.karynad.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationListener {

    @RabbitListener(queues = "notification.user.created.queue")
    public void handleUserCreated(String json) {
        System.out.println("Creating tasks for user: " + json);
        // Логика создания приветственных задач для нового пользователя
    }

}
