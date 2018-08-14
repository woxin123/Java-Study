package top.mcwebsite.security.service.impl;

import org.springframework.stereotype.Service;
import top.mcwebsite.security.service.HelloService;

/**
 * 18-7-24 下午3:30
 * @author mengchen
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello" + name;
    }
}
