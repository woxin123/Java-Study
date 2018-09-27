package com.example.websockettest.websocket;

import com.example.websockettest.session.MyWebSocketHandlerDecoratorFactory;
import com.example.websockettest.websocket.interceptor.MyChannelInterceptor;
import com.example.websockettest.websocket.interceptor.MyHandShakeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.socket.config.WebSocketMessageBrokerStats;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
import org.springframework.web.socket.handler.ConcurrentWebSocketSessionDecorator;
import org.springframework.web.socket.sockjs.transport.session.WebSocketServerSockJsSession;

@Configuration
@EnableWebSocketMessageBroker   // 表示开启使用STOMP协议来传输基于代理的消息，Broker就是代理的意思
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
//    ConcurrentWebSocketSessionDecorator
//    WebSocketServerSockJsSession


    @Autowired
    SimpUserRegistry simpUserRegistry;

    @Autowired
    private MyChannelInterceptor myChannelInterceptor;


    @Override   // 注册STOMP协议的节点，并指定映射URL。
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册STOMP协议节点，同时指定使用SockJS协议
        registry.addEndpoint("/endpointSang")
                .withSockJS();
    }

    // 配置消息代理，这里的消息代理是/topic
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //应用程序以/app为前缀，代理目的地以/topic、/user为前缀
        registry.enableSimpleBroker("/topic", "/user");
        registry.setApplicationDestinationPrefixes("/app");
        registry.setUserDestinationPrefix("/user");

    }

    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(myChannelInterceptor);
    }

}
