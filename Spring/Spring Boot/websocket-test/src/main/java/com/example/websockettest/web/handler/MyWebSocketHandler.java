package com.example.websockettest.web.handler;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.WebSocketHandlerDecorator;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author mengchen
 * @time 18-9-15 下午2:13
 */
public class MyWebSocketHandler extends WebSocketHandlerDecorator {

    public CopyOnWriteArrayList<WebSocketSession> users = new CopyOnWriteArrayList();

    public MyWebSocketHandler(WebSocketHandler delegate) {
        super(delegate);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        System.out.println(session.getId());
        System.out.println("连接成功");
        users.add(session);
        super.afterConnectionEstablished(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("连接关闭");
        users.remove(session);
        users.stream().forEach((s) -> {
            System.out.println(s.getId());
        });
        super.afterConnectionClosed(session, closeStatus);
    }


}
