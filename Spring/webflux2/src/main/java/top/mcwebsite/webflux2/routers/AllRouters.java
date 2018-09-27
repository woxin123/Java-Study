package top.mcwebsite.webflux2.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import top.mcwebsite.webflux2.handlers.UserHandler;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

/**
 * @author mengchen
 * @time 18-8-24 下午9:36
 */
@Configuration
public class AllRouters {

    @Bean
    public RouterFunction<ServerResponse> userRouter(UserHandler userHandler) {
        return nest(
                // 相当于RequestMapping上面的@RequestMapping("/user")
                path("/user"),
                // 相当于类里面的@RequestMapping
                route(GET("/"), userHandler::getAllUser)
                        .andRoute(GET("/{id}"), userHandler::getUserById)
                        // 创建用户
                        .andRoute(POST("/").and(accept(APPLICATION_JSON_UTF8)), userHandler::createUser)
                        // 删除用户
                        .andRoute(DELETE("/{id}"), userHandler::deleteUserById)
        );

    }

}
