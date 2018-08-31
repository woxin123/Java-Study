package com.example.webflux.web.controller;

import com.example.webflux.domain.User;
import com.example.webflux.repository.UserRepository;
import com.example.webflux.util.CheckUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author mengchen
 * @time 18-8-24 下午3:21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private Integer start;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 以数组形式一次性返回数据
     *
     * @return
     */
    @GetMapping("/")
    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * 以SSE形式多次返回数据
     *
     * @return
     */
    @GetMapping(value = "/stream/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> streamGetAll() {
        return userRepository.findAll();
    }

    /**
     * 新增数据
     *
     * @param user
     * @return
     */
    @PostMapping("/")
    public Mono<User> createUser(@Valid @RequestBody User user) {
        // 在spring data jpa是新增和修改都是save，有id的时候是新增，没有id的时候是修改
        // 根据实际情况是否置空id
        CheckUtil.checkName(user.getName());
        return userRepository.save(user);
    }

    /**
     * 根据id删除用户
     * 存在的时候删除返回200
     * 不存在的时候返回404
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable String id) {

        // deleteById没有返回值不能判断数据是否存在
        return userRepository.findById(id)
                // 当操作数据，并返回一个Mono的时候使用flatMap
                // 当如果不操作数据，只是对数据做一个转换使用map
                .flatMap(user -> userRepository.delete(user)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    /**
     * 修改数据
     * 存在的时候返回200，不存在的时候返回404
     *
     * @param id
     * @param user
     * @return
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> updateUser(@PathVariable String id,
                                                 @Valid @RequestBody User user) {
        CheckUtil.checkName(user.getName());
        return userRepository.findById(id)
                // flatMap 修改数据
                .flatMap(u -> {
                    u.setName(user.getName());
                    u.setAge(user.getAge());
                    return userRepository.save(u);
                })
                // 转换数据
                .map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> getUserById(@PathVariable String id) {
        return userRepository.findById(id)
                // 转换数据
                .map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * 根据年龄段查找
     * @param start
     * @param end
     * @return
     */
    @GetMapping(value = "/stream/age/{start}/{end}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> streamGetByAge(@PathVariable Integer start,
                               @PathVariable Integer end) {
        return userRepository.findByAgeBetween(start, end);
    }

    @GetMapping(value = "/age/{start}/{end}")
    public Flux<User> getByAge(@PathVariable Integer start,
                               @PathVariable Integer end) {
        return userRepository.findByAgeBetween(start, end);
    }

    @GetMapping(value = "stream/old", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> streamOldUser() {

        return userRepository.oldUser();
    }

    @GetMapping("/old")
    public Flux<User> oldUser() {

        return userRepository.oldUser();
    }
}
