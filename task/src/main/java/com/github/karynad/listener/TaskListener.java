package com.github.karynad.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TaskListener {

    @RabbitListener(queues = "task.user.created.queue")
    public void handleUserCreated(String json) {
        System.out.println("Creating tasks for user: " + json);
        // Логика создания приветственных задач для нового пользователя
    }

    @RabbitListener(queues = "task.user.deleted.queue")
    public void handleUserDeleted(String json) {
        System.out.println("Deleting tasks for user: " + json);
        // Логика создания приветственных задач для нового пользователя
    }
}
