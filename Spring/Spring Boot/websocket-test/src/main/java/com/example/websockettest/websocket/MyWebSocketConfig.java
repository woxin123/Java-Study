package com.example.websockettest.websocket;

import com.example.websockettest.web.handler.MyWebSocketHandler;
import com.example.websockettest.websocket.interceptor.MyHandShakeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author mengchen
 * @time 18-9-15 下午2:15
 */
//@Configuration
//@EnableWebSocket
public class MyWebSocketConfig implements WebSocketConfigurer {


    @Autowired
    private MyWebSocketHandler webSocketHandler;

    @Autowired
    private MyHandShakeInterceptor handShakeInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, "/topic").addInterceptors(handShakeInterceptor);
    }
}
