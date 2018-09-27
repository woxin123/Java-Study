package com.example.websockettest.session;

import com.example.websockettest.web.handler.MyWebSocketHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.handler.WebSocketHandlerDecoratorFactory;

/**
 * @author mengchen
 * @time 18-9-15 下午4:00
 */
@Component
public class MyWebSocketHandlerDecoratorFactory implements WebSocketHandlerDecoratorFactory {


    private MyWebSocketHandler myWebSocketHandler;


    public MyWebSocketHandlerDecoratorFactory() {

    }

    @Override
    public WebSocketHandler decorate(WebSocketHandler handler) {
        if (this.myWebSocketHandler == null) {
            this.myWebSocketHandler = new MyWebSocketHandler(handler);
        }
        return myWebSocketHandler;
    }
}
