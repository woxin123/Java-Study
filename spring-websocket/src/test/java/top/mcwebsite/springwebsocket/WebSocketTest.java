package top.mcwebsite.springwebsocket;

import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

/**
 * @author mengchen
 * @time 18-10-10 下午10:04
 */
public class WebSocketTest {
    public static void main(String[] args) {
        WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();

    }
}
