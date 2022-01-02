package com.asimkilic.sr.listener;

import com.asimkilic.sr.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {
// Kuyruktaki notificationları dinler

    @RabbitListener(queues = "asim-kilic-queue")
    public void handleMessage(Notification notification){
        System.out.println("Message received...");
        System.out.println(notification.toString());
    }
}

