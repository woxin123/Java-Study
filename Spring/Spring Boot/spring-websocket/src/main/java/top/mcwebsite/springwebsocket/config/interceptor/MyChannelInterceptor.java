package top.mcwebsite.springwebsocket.config.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Component;
import top.mcwebsite.springwebsocket.model.User;

/**
 * @author mengchen
 * @time 18-9-11 下午5:00
 */
@Log4j2
@Component
public class MyChannelInterceptor implements ChannelInterceptor {

    @Autowired
    private SimpUserRegistry simpUserRegistry;

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        log.info("用户进入preSend方法");
        StompHeaderAccessor accessor =
                MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            String name = accessor.getFirstNativeHeader("name");
            accessor.setUser(new User(name));
        }

        return message;
    }

}
