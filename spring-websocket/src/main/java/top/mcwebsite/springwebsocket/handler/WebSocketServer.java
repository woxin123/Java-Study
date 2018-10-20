package top.mcwebsite.springwebsocket.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.message.ObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import top.mcwebsite.springwebsocket.domain.Book;
import top.mcwebsite.springwebsocket.message.JsonMessage;
import top.mcwebsite.springwebsocket.util.WebSocketMessageUtil;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mengchen
 * @time 18-10-10 下午9:31
 */
@Component
public class WebSocketServer implements WebSocketHandler {

    private static AtomicInteger onlineCount = new AtomicInteger(0);

    private static ConcurrentHashMap<Integer, WebSocketSession> onLineUser = new ConcurrentHashMap<>();

    @Autowired
    private WebSocketMessageUtil webSocketMessageUtil;

    private WebSocketSession session;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        onLineUser.put(Integer.parseInt((String) webSocketSession.getAttributes().get("userId")), webSocketSession);
        onlineCount.incrementAndGet();
        System.out.println("有新的连接加入！当前在线人数为：" + onlineCount);
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        Book book = new Book(1, "我的世界");
        sendMessageToUsers(book);
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        if (webSocketSession.isOpen()) {
            webSocketSession.close();
        }
        onLineUser.remove(webSocketSession.getAttributes().get("userId"));
        throwable.getStackTrace();
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        onlineCount.decrementAndGet();
        onLineUser.remove(webSocketSession.getAttributes().get("userId"));
        System.out.println("有一连接关闭！当前在线人数为：" + onlineCount);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    public void sendMessageToUsers(Book book) throws IOException {
        for (Map.Entry<Integer, WebSocketSession> entry : onLineUser.entrySet()) {
            entry.getValue().sendMessage(webSocketMessageUtil.jsonTextMessage(book));
        }
    }
}
