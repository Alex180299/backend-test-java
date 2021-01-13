package com.test.demo.api.controller;

import com.test.demo.api.service.CommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunicationController
{
    @Autowired
    public CommunicationService service;

    @GetMapping("/communicate")
    public String communicate()
    {
        service.communicate();
        return "Communicating";
    }
}
