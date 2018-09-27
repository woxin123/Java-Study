package top.mcwebsite.springwebsocket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import top.mcwebsite.springwebsocket.config.interceptor.MyChannelInterceptor;

/**
 * @author mengchen
 */
@Configuration
@EnableWebSocketMessageBroker   // 表示开启使用STOMP协议来传输基于代理的消息，Broker就是代理的意思
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Autowired
    SimpUserRegistry simpUserRegistry;



    @Override   // 注册STOMP协议的节点，并指定映射URL。
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册STOMP协议节点，同时指定使用SockJS协议
        registry.addEndpoint("/endpointSang").setAllowedOrigins("http://localhost:63343")
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
        registration.interceptors(new MyChannelInterceptor());
    }
}
