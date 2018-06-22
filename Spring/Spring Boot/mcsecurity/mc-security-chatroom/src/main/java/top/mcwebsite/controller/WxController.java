package top.mcwebsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class WxController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if (principal.getName().equals("woxin")) {
            messagingTemplate.convertAndSendToUser("user",
                    "/queue/notifications",
                    principal.getName() + "-sned:" + msg);
        }else {
            messagingTemplate.convertAndSendToUser("woxin",
                    "/queue/notifications",
                    principal.getName() + "-sned:" + msg);
        }
    }
}
