package com.test.demo.service;

import com.google.gson.Gson;
import com.test.demo.model.Session;
import com.test.demo.tcp.TcpClient;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class SessionsService
{
    private Gson gson;

    @Getter
    private List<Session> sessions;

    @Autowired
    private FilterService filterService;

    @Autowired
    private MessageService messageService;

    @PostConstruct
    private void configureSessions()
    {
        sessions = new ArrayList<>();
        sessions.add(new Session(1, 0, 0));
        sessions.add(new Session(2, 0, 0));
        sessions.add(new Session(3, 0, 0));
        sessions.add(new Session(4, 0, 0));
        sessions.add(new Session(5, 0, 0));
        sessions.add(new Session(6, 0, 0));
        sessions.add(new Session(7, 0, 0));
        sessions.add(new Session(8, 0, 0));
        sessions.add(new Session(9, 0, 0));
        sessions.add(new Session(10, 0, 0));

        gson = new Gson();
    }

    public void sendSessions()
    {
        byte[] bytes = gson.toJson(sessions).getBytes();
        messageService.send(TcpClient.WS_ROUTE + "/config", bytes);
    }

    public void filterAndSend(String s, byte[] bytesMessage)
    {
        for (Session session : sessions)
        {
            if (filterService.filter(s))
            {
                session.setApproved(session.getApproved() + 1);
            }
            else
            {
                session.setDisapproved(session.getDisapproved() + 1);
            }

            byte[] bytes = gson.toJson(sessions).getBytes();
            messageService.send(TcpClient.WS_ROUTE + "/config", bytes);
        }
    }
}
