package top.mcwebsite.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.mcwebsite.domain.WoxinMessage;
import top.mcwebsite.vo.WoxinResponse;

@Controller
public class WxController {

    // 当浏览器向服务器发送请求时，通过@MessageMapping映射/welcome这个地址，类似于@RequestMapping
    @MessageMapping("/welcome")
    // 当服务器有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
    @SendTo("/topic/getResponse")
    public WoxinResponse say(WoxinMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new WoxinResponse("Welcome, " + message.getName() + "!");
    }


}
