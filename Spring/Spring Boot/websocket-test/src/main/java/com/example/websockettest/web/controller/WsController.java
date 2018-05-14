package com.example.websockettest.web.controller;

import com.example.websockettest.model.RequestMessage;
import com.example.websockettest.model.ResponseMessage;
import org.jboss.logging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.xml.ws.Response;

@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage message) {
        System.out.println(message.getName());
        return new ResponseMessage("Welcome," + message.getName() + " !");
    }
}
