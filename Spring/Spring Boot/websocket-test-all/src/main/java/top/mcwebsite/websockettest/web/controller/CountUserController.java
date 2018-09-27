package top.mcwebsite.websockettest.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mengchen
 * @time 18-9-23 下午1:58
 */
@RestController
@Slf4j
public class CountUserController {

    /**
     * Spring 提供的发送消息的模板
     */
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /**
     * 这是一个管理注册用户的类
     */
    @Autowired
    private SimpUserRegistry userRegistry;

    @RequestMapping("/countUsers")
    public void countUsers() {
        log.info("当前在线人数：" + userRegistry.getUserCount());
        for (SimpUser user : userRegistry.getUsers()) {
            log.info("用户" + user.getName() + "在线，用户信息：" + user);
        }
        simpMessagingTemplate.convertAndSend("/topic/getResponse", "共有" + userRegistry.getUserCount() + "在线");
    }

}
