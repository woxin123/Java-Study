package top.mcwebsite.springwebsocket.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.WebSocketMessage;

/**
 * @author mengchen
 * @time 18-10-17 下午4:25
 */
public class JsonMessage<T> implements WebSocketMessage<String> {

    private T data;

    private ObjectMapper objectMapper;

    private String jsonString;


    public JsonMessage(T data, ObjectMapper objectMapper) throws JsonProcessingException {
        this.data = data;
        this.objectMapper = objectMapper;
        this.jsonString = objectMapper.writeValueAsString(data);
    }

    @Override
    public String getPayload() {
        return jsonString;
    }

    @Override
    public int getPayloadLength() {
        return jsonString.getBytes().length;
    }

    @Override
    public boolean isLast() {
        return true;
    }
}
