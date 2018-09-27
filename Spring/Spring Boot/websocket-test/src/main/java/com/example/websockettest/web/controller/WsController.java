package com.example.websockettest.web.controller;

import com.example.websockettest.model.RequestMessage;
import com.example.websockettest.model.ResponseMessage;
import org.jboss.logging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.handler.ConcurrentWebSocketSessionDecorator;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

import javax.xml.ws.Response;

/**
 * @author mengchen
 */
@RestController
public class WsController {
    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage message) {
        System.out.println(message.getName());
        return new ResponseMessage("Welcome," + message.getName() + " !");
    }

    @RequestMapping("/send")
    public String send() {
        simpMessageSendingOperations.convertAndSendToUser("1", "/topic/message", "hello");
        return "hello";
    }


}
