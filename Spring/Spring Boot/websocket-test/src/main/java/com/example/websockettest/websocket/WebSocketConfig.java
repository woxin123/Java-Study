package com.example.websockettest.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker   // 表示开启使用STOMP协议来传输基于代理的消息，Broker就是代理的意思
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override   // 注册STOMP协议的节点，并指定映射URL。
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册STOMP协议节点，同时指定使用SockJS协议
        registry.addEndpoint("/endpointSang").withSockJS();
    }

    // 配置消息代理，这里的消息代理是/topic
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
