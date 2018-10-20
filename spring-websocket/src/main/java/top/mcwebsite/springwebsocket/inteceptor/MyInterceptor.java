package top.mcwebsite.springwebsocket.inteceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

import javax.websocket.server.ServerEndpoint;

/**
 * @author mengchen
 * @time 18-10-17 下午7:50
 */
@Component
public class MyInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        System.out.println(message.getPayload());
        return message;
    }
}
