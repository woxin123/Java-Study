package top.mcwebsite.singletonpointloginin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.mcwebsite.singletonpointloginin.common.ServerResponse;
import top.mcwebsite.singletonpointloginin.dao.UserRepository;
import top.mcwebsite.singletonpointloginin.model.User;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author mengchen
 * @time 18-11-17 下午4:55
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    private final RedisTemplate<String, String> redisTemplate;

    private final ObjectMapper objectMapper;

    @Autowired
    public UserService(UserRepository userRepository, RedisTemplate<String, String> redisTemplate, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
    }

    public ServerResponse<String> login(String username, String password) throws JsonProcessingException {
        Optional<User> userA = userRepository.findById(username);

        if (!userA.isPresent()) {
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        User user = userA.get();
        if (!user.getPassword().equals(password)) {
            return ServerResponse.createByErrorMessage("用户名或密码错误");
        }
        String token = UUID.randomUUID().toString();
        user.setPassword(null);
        redisTemplate.opsForValue()
                .set("USER_INFO" + ":" + token, objectMapper.writeValueAsString(user), 1L, TimeUnit.HOURS);
        return ServerResponse.createBySuccess(token);
    }

    public ServerResponse<User> getUserFromToken(String token) throws IOException {
        String userJson = redisTemplate.opsForValue().get("USER_INFO" + ":" + token);
        User user = null;
        if (userJson != null) {
            user = objectMapper.readValue(userJson, User.class);
        } else {
            return ServerResponse.createByErrorMessage("用户没有登录");
        }
        return ServerResponse.createBySuccess(user);
    }
}
