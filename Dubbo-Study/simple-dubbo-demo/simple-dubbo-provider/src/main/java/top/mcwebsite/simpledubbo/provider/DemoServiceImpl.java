package top.mcwebsite.simpledubbo.provider;

import org.springframework.stereotype.Service;
import top.mcwebsite.simpledubbo.api.DemoService;

/**
 * @author mengchen
 * @time 18-12-12 下午10:43
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return name + "，你好，我是provider，以后哦我们得好好交流了！";
    }
}
