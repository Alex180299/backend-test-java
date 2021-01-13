package com.test.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
public class MessageService
{
    @Autowired
    SimpMessagingTemplate template;

    public void send(String destination, byte[] message)
    {
        template.send(destination, new GenericMessage<>(message));
    }
}
