package com.test.demo.api.service;

import com.test.demo.service.SessionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunicationService
{
    @Autowired
    private SessionsService sessionsService;

    public void communicate()
    {
        sessionsService.sendSessions();
    }
}
