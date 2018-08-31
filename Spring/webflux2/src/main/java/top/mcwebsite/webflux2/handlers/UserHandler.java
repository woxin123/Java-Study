package top.mcwebsite.webflux2.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import top.mcwebsite.webflux2.domain.User;
import top.mcwebsite.webflux2.repository.UserRepository;
import top.mcwebsite.webflux2.util.CheckUtil;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.server.ServerResponse.*;

/**
 * @author mengchen
 * @time 18-8-24 下午9:23
 */
@Component
@Slf4j
public class UserHandler {

    private final UserRepository userRepository;

    public UserHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 得到所有用户信息
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> getAllUser(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON_UTF8)
                .body(userRepository.findAll(), User.class);
    }


    /**
     * 创建用户
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> createUser(ServerRequest request) {

        Mono<User> userMono = request.bodyToMono(User.class);

        userMono.map(user -> {
            log.info(String.valueOf(user));
            return user;
        });


        return userMono.flatMap(user -> {
            // 校验方法放在这里
            CheckUtil.checkName(user.getName());
            return ok().contentType(APPLICATION_JSON_UTF8)
                    .body(userRepository.save(user), User.class);
        });
    }

    /**
     * 根据id删除用户
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> deleteUserById(ServerRequest request) {

        String id = request.pathVariable("id");

        return userRepository.findById(id).flatMap(user ->
                userRepository.delete(user).then(ok().build()))
                .switchIfEmpty(notFound().build());

    }
}
