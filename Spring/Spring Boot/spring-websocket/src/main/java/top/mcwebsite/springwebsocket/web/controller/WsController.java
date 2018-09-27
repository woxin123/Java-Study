package top.mcwebsite.springwebsocket.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mcwebsite.springwebsocket.model.RequestMessage;
import top.mcwebsite.springwebsocket.model.ResponseMessage;


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
