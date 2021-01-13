package com.test.demo.controller;

import com.test.demo.model.Greeting;
import com.test.demo.model.HelloMessage;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Log4j2
@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/sessions/config")
    public Greeting greeting(HelloMessage message) throws Exception {
        log.info("Message received: {}", message);
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
