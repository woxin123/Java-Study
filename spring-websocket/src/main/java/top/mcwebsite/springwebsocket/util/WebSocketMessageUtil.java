package top.mcwebsite.springwebsocket.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

/**
 * @author mengchen
 * @time 18-10-17 下午7:23
 */
@Component
public class WebSocketMessageUtil {

    @Autowired
    private ObjectMapper objectMapper;


    public<T> TextMessage jsonTextMessage(T data) {
        try {
            return new TextMessage(objectMapper.writeValueAsString(data));
        } catch (JsonProcessingException e) {
            System.out.println("Json解析错误");
            e.printStackTrace();
            return null;
        }
    }

}
