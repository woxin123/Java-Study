package com.example.webfluxclient;

import com.example.webfluxclient.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author mengchen
 * @time 18-9-19 下午8:02
 */

@RestController
public class TestController {

    /**
     * 直接注入定义的接口
     */
    @Autowired
    IUserApi userApi;

    @GetMapping("/")
    public void test() {
        // 测试信息提取
        // 不订阅会实际发出请求，但会进入代理类
//        Flux<User> users = userApi.getAllUser();
//        userApi.getUserById("111111");
//        userApi.deleteUserById("22222");
//        userApi.creteUser(Mono.just(User.builder().name("xfq").age(33).build()));
        String id = "5b7fcffca7986c43ba866e35";
        userApi.getUserById(id).subscribe(user -> {
            System.out.println("getById:" + user);
        }, e -> {
            System.out.println("找不到用户：" + e.getMessage());
        });

        String nid = "5ba3163e7a4d00092d1a4502";
        userApi.getUserById(nid).subscribe(user -> {
            System.out.println("getById:" + user);
        }, e -> {
            System.out.println("找不到用户：" + e.getMessage());
        });

//        System.out.println("aaaa");
//        userApi.deleteUserById(id).subscribe();
        // 创建用户
//        userApi.creteUser(Mono.just(User.builder().name("mc").age(18).build()))
//                .subscribe(System.out::println);
    }

}
